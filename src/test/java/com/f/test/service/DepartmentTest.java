package com.f.test.service;

import com.f.core.pojo.Department;
import com.f.dao.DepartmentDao;
import com.f.services.impl.AbstractGenericService;
import com.f.services.impl.DepartmentServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.redisson.api.RedissonClient;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class DepartmentTest {
    @Mock
    private DepartmentDao departmentDao;

    @Mock
    private AbstractGenericService abstractGenericService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Mock
    private RedissonClient redisHelper;

    @BeforeAll
    void setup() {
        MockitoAnnotations.initMocks(this);
        departmentService.setMapper(departmentDao);
        departmentService.setRedissonClient(redisHelper);
    }

    @Test
    public void getDepartmentList() {
        List<Department> list = Lists.newArrayList(new Department("foo"), new Department("bar"));
        when(abstractGenericService.getAll()).thenReturn(Collections.singletonList(list));
        assert abstractGenericService.getAll().size() > 0;
        verify(abstractGenericService, times(1)).getAll();
        verifyNoMoreInteractions(abstractGenericService);
    }
}
