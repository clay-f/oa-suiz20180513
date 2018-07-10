package com.f.services.impl;

import com.f.core.pojo.Dict;
import com.f.dao.DictDao;
import com.f.dao.GenericMapper;
import com.f.services.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("dictService")
public class DictServiceImpl extends AbstractGenericService<Dict, Integer> implements DictService {
    private DictDao dictDao;

    @Transactional
    @Override
    public void save(Map<String, Object> map) {
        dictDao.save(map);
    }

    @Autowired
    public DictServiceImpl(@Qualifier("dictDao") GenericMapper mapper) {
        super(mapper);
        this.dictDao = (DictDao) mapper;
    }
}
