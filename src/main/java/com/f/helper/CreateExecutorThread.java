package com.f.helper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateExecutorThread {
    private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static final ExecutorService singleThreadPool = Executors.newFixedThreadPool(4);

    public CreateExecutorThread() {
    }

    public static ExecutorService getCachedThreadPool() {
        return cachedThreadPool;
    }

    public static ExecutorService getSingleThreadPool() {
        return singleThreadPool;
    }
}
