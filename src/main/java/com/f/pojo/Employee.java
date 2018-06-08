package com.f.pojo;

import com.fasterxml.jackson.annotation.JsonView;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee extends BasePojo {
    private String name;
    private String passwd;
    private Integer departmentId;
    private Integer oaPositionId;

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
    @NotNull
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @JsonView(EmployeePojoView.class)
    @NotNull
    public Integer getOaPositionId() {
        return oaPositionId;
    }

    public void setOaPositionId(Integer oaPositionId) {
        this.oaPositionId = oaPositionId;
    }
}
