package com.demo.lockspringbootstarter.config;

import com.demo.lockspringbootstarter.lock.manager.LockFactory;
import com.demo.lockspringbootstarter.lock.manager.LockManager;
import io.etcd.jetcd.Client;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties({LockProperties.class})
public class LockAutoConfiguration {

    private LockProperties lockProperties;

    public LockAutoConfiguration(LockProperties lockProperties) {
        this.lockProperties = lockProperties;
    }

    @Bean
    public LockFactory lockFactory(){
        return new LockFactory();
    }

    @Bean
    public LockManager lockmanager(){
        return new LockManager(lockProperties.getLockType());
    }

    @Bean
    public ZooKeeper zooKeeper(){
        try {
            return new ZooKeeper(lockProperties.getZookeeperUrl(), 10000, null);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Bean
    public Client etcdClient(){
        return Client.builder().endpoints(lockProperties.getEtcdUrl()).build();
    }
}
