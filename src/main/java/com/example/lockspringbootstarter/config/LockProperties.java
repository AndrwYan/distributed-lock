package com.example.lockspringbootstarter.config;

import com.example.lockspringbootstarter.lock.manager.LockFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("lock")
@Component
public class LockProperties {

    private String lockType = LockFactory.REDIS;

    private String zookeeperUrl = "127.0.0.1:2181";

    private String etcdUrl = "http://127.0.0.1:2379";

    public String getZookeeperUrl() {
        return zookeeperUrl;
    }

    public void setZookeeperUrl(String zookeeperUrl) {
        this.zookeeperUrl = zookeeperUrl;
    }

    public String getEtcdUrl() {
        return etcdUrl;
    }

    public void setEtcdUrl(String etcdUrl) {
        this.etcdUrl = etcdUrl;
    }

    public String getLockType() {
        return lockType;
    }

    public void setLockType(String lockType) {
        this.lockType = lockType;
    }

}
