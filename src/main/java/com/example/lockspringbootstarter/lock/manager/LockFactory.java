package com.example.lockspringbootstarter.lock.manager;

import com.example.lockspringbootstarter.dao.SdkDistributeLockDao;
import com.example.lockspringbootstarter.lock.*;
import io.etcd.jetcd.Client;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


public class LockFactory {

    private StringRedisTemplate stringRedisTemplate;

    private ZooKeeper zooKeeper;

    private DataSourceTransactionManager dataSourceTransactionManager;

    private SdkDistributeLockDao sdkDistributeLockDao;

    private Client etcdClient;

    public LockFactory() {
    }

    public LockFactory(StringRedisTemplate stringRedisTemplate, ZooKeeper zooKeeper, DataSourceTransactionManager dataSourceTransactionManager, SdkDistributeLockDao sdkDistributeLockDao, Client etcdClient) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.zooKeeper = zooKeeper;
        this.dataSourceTransactionManager = dataSourceTransactionManager;
        this.sdkDistributeLockDao = sdkDistributeLockDao;
        this.etcdClient = etcdClient;
    }

    public static final String REDIS = "redis";
    public static final String ZOOKEEPER = "zookeeper";
    public static final String MYSQL = "mysql";
    public static final String ETCD = "etcd";

    public AbstractLock getLock(String lockType,String lockName){
        switch (lockType){
            case REDIS:
                return new RedisLock(stringRedisTemplate, lockName);
            case ZOOKEEPER:
                return new ZookeeperLock(zooKeeper, lockName);
            case MYSQL:
                return new MysqlLock(sdkDistributeLockDao, lockName,dataSourceTransactionManager);
            case ETCD:
                return new EtcdLock(etcdClient, lockName);
            default:
                return null;
        }
    }

}
