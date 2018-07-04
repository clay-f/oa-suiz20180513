package com.f.core.pojo;


import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashSet;
import java.util.Set;

public class Department extends BasePojo {
    private String name;
    private Set<Employee> employees = new HashSet<Employee>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public static interface DepartmentPojoView extends BasePojoView {

    }

    @JsonView(DepartmentPojoView.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}