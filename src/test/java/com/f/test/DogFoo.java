package com.f.test;

import com.f.pojo.Employee;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class DogFoo extends FanXingClass<Employee> {
    DogFoo() {
        System.out.println("child constructor");
    }

    @Test
    void readFiles() throws IOException {
        List<?> list = Files.asCharSource(Paths.get("/Users/f/Documents/develop/workspace/jboa/build.gradle").toFile(), Charsets.UTF_8).readLines();
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
