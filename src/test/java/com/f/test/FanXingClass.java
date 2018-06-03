package com.f.test;

import java.lang.reflect.ParameterizedType;

public class FanXingClass<T> {
    private Class<T> clasz;

    public FanXingClass() {
        clasz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        System.out.println(clasz.getSimpleName());
    }
}
