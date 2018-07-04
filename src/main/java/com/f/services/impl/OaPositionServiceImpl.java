package com.f.services.impl;

import com.f.dao.GenericMapper;
import com.f.core.pojo.OaPosition;
import com.f.services.OaPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("oaPositionService")
public class OaPositionServiceImpl extends AbstractGenericService<OaPosition, Integer> implements OaPositionService {
    @Autowired
    public OaPositionServiceImpl(@Qualifier("oaPositionDao") GenericMapper mapper) {
        super(mapper);
    }
}
