package com.f.helper;

import org.redisson.api.*;
import org.springframework.stereotype.Component;

@Component
public class RedisHelper {

    public static <T> RBucket<T> getRBucket(RedissonClient redissonClient, String objectName) {
        RBucket<T> bucket = redissonClient.getBucket(objectName);
        return bucket;
    }


    public static <K, V> RMap<K, V> getRMap(RedissonClient redissonClient, String objectName) {
        RMap<K, V> map = redissonClient.getMap(objectName);
        return map;
    }


    public static <V> RSortedSet<V> getRSortedSet(RedissonClient redissonClient, String objectName) {
        RSortedSet<V> sortedSet = redissonClient.getSortedSet(objectName);
        return sortedSet;
    }


    public static <V> RSet<V> getRSet(RedissonClient redissonClient, String objectName) {
        RSet<V> rSet = redissonClient.getSet(objectName);
        return rSet;
    }


    public static <V> RList<V> getRList(RedissonClient redissonClient, String objectName) {
        RList<V> rList = redissonClient.getList(objectName);
        return rList;
    }

    public static <V> RQueue<V> getRQueue(RedissonClient redissonClient, String objectName) {
        RQueue<V> rQueue = redissonClient.getQueue(objectName);
        return rQueue;
    }


    public static <V> RDeque<V> getRDeque(RedissonClient redissonClient, String objectName) {
        RDeque<V> rDeque = redissonClient.getDeque(objectName);
        return rDeque;
    }

    public static RLock getRLock(RedissonClient redissonClient, String objectName) {
        RLock rLock = redissonClient.getLock(objectName);
        return rLock;
    }


    public static RAtomicLong getRAtomicLong(RedissonClient redissonClient, String objectName) {
        RAtomicLong rAtomicLong = redissonClient.getAtomicLong(objectName);
        return rAtomicLong;
    }


    public static RCountDownLatch getRCountDownLatch(RedissonClient redissonClient, String objectName) {
        RCountDownLatch rCountDownLatch = redissonClient.getCountDownLatch(objectName);
        return rCountDownLatch;
    }

    static <M> RTopic<M> getRTopic(RedissonClient redissonClient, String objectName) {
        RTopic<M> rTopic = redissonClient.getTopic(objectName);
        return rTopic;
    }
}
