package com.example.lockspringbootstarter.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 1.子类只需要实现想实现的方法
 * 2.新增抽象类中的方法
 **/
public abstract class AbstractLock implements Lock {

    protected String lockName;

    @Override
    public void lock() {

    }

    public void lock(TimeUnit timeUnit, Long expireTime) {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public boolean tryLock(long time, long expireTime, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
