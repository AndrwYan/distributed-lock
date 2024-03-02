package com.demo.lockspringbootstarter.lock.manager;

import com.demo.lockspringbootstarter.lock.AbstractLock;

import javax.annotation.Resource;

public class LockManager {

    @Resource
    private LockFactory lockFactory;

    private String lockType;

    public LockManager(String lockType) {
        this.lockType = lockType;
    }

    public AbstractLock getLock(String lockName) {
        return lockFactory.getLock(lockType,lockName);
    }

}
