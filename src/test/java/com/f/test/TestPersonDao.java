package com.f.test;

import com.f.core.pojo.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class TestPersonDao {

    @Test
    void say() throws IllegalAccessException {
        PersonDao personDao = new PersonDao();
        Employee employee = personDao.get(1);
        Class clazz = personDao.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field
                : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + "\t"   + field.get(personDao));
        }
    }
}
