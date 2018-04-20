package com.f.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelper {
    private static ApplicationContext context;

    private TestHelper() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static TestHelper getInstance() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        public static final TestHelper INSTANCE = new TestHelper();
    }

    public Object getBean(String s) {
        return context.getBean(s);
    }

}
