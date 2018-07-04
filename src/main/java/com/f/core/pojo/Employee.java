package com.f.core.pojo;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee extends BasePojo {
    private String name;
    private String passwd;
    private OaPosition oaPosition;
    private Department department;

    public Employee() {
    }

    public Employee(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public static interface EmployeePojoView extends BasePojoView, Department.DepartmentPojoView, OaPosition.OaPositionPojoView {

    }

    @JsonView(EmployeePojoView.class)
    @NotNull
    @Size(min = 2, message = "name min value must great than 2")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(EmployeePojoView.class)
    @NotNull
    @Size(min = 6, max = 20, message = "password length between 6 and 20")
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @JsonView(EmployeePojoView.class)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonView(EmployeePojoView.class)
    public OaPosition getOaPosition() {
        return oaPosition;
    }

    public void setOaPosition(OaPosition oaPosition) {
        this.oaPosition = oaPosition;
    }
}
