package com.f.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.sql.Timestamp;

public class Employee {
    private Integer id;
    private String name;
    private String passwd;
    private Integer departmentId;
    private Integer oaPositionId;
    private Timestamp createdAt;
    private Time updatedAt;

    public Employee() {
    }

    public Employee(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 2, message = "name min value must great than 2")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 6, max = 20, message = "password length between 6 and 20")
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @NotNull
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @NotNull
    public Integer getOaPositionId() {
        return oaPositionId;
    }

    public void setOaPositionId(Integer oaPositionId) {
        this.oaPositionId = oaPositionId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Time getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Time updatedAt) {
        this.updatedAt = updatedAt;
    }
}
