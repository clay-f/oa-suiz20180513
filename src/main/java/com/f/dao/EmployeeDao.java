package com.f.dao;

import com.f.core.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;

@Scope("prototype")
public interface EmployeeDao extends GenericDao<Employee, Integer> {
    List<Employee> getUserByCondition(Map<String, Object> map);

    void save(@Param("name") String name, @Param("passwd") String passwd, @Param("departmentId") Integer departmentId, @Param("oaPositionId") Integer oaPositionId);
}
