package com.example.lockspringbootstarter.lock.manager;

import com.example.lockspringbootstarter.lock.AbstractLock;
import org.springframework.beans.factory.annotation.Autowired;

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
