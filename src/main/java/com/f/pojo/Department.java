package com.f.pojo;


import com.fasterxml.jackson.annotation.JsonView;

public class Department extends BasePojo {
    private String name;

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
}