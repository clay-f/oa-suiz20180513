package com.f.services.impl;

import com.f.core.pojo.Dict;
import com.f.dao.DictDao;
import com.f.dao.GenericDao;
import com.f.services.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("dictService")
public class DictServiceImpl extends AbstractGenericService<Dict, Long> implements DictService {
    private DictDao dictDao;

    @Transactional
    @Override
    public void save(Dict dict, Long dicTypeId) {
        dictDao.save(dict, dicTypeId);
    }

    @Autowired
    public DictServiceImpl(@Qualifier("dictDao") GenericDao mapper) {
        super(mapper);
        this.dictDao = (DictDao) mapper;
    }
}
