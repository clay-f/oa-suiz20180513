package com.f.services.impl;

import com.f.core.pojo.DictType;
import com.f.dao.GenericDao;
import com.f.services.DictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dictTypeService")
public class DictTypeServiceImpl extends AbstractGenericService<DictType, Long> implements DictTypeService {
    @Autowired
    public DictTypeServiceImpl(@Qualifier(value = "dictTypeDao") GenericDao mapper) {
        super(mapper);
    }
}
