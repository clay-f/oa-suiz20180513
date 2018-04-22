package com.f.services.impl;

import com.f.dao.OaPositionDao;
import com.f.pojo.OaPosition;
import com.f.services.OaPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OaPositionServiceImpl implements OaPositionService {
    @Autowired(required = true)
    private OaPositionDao oaPositionDao;

    @Transactional
    @Override
    public List<OaPosition> getPositionList() {
        List<OaPosition> oaPositions = new ArrayList<OaPosition>();
        try {
            oaPositions = oaPositionDao.getAllOaPosition();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return oaPositions;
    }
}
