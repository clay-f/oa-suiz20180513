package com.f.services.impl;

import com.f.dao.GenericCrudMapper;
import com.f.pojo.OaPosition;
import com.f.services.OaPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OaPositionServiceImpl extends GenericCrudService<OaPosition, Integer> implements OaPositionService {
    @Autowired
    public OaPositionServiceImpl(@Qualifier("oaPositionDao") GenericCrudMapper mapper) {
        super(mapper);
    }
}
