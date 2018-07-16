package com.f.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Dao<T> {
    public Dao() {
        System.out.println(this.getClass().getSuperclass());
        Type type = this.getClass().getGenericSuperclass();
        System.out.println(type);
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] args = parameterizedType.getActualTypeArguments();
            System.out.println(Arrays.asList(args));
            if (args != null) {
                Type arg = args[0];
                System.out.println(arg);
                Class clazz = (Class) arg;
            }
        }

    }

    T get(Integer id) {
        return null;
    }
}
