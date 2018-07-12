package com.f.dao;

import com.f.core.pojo.Dict;
import org.apache.ibatis.annotations.Param;


public interface DictDao extends GenericDao<Dict, Integer> {
    void save(@Param("dict")Dict dictType, @Param("dictTypeId") Long dictTypeId);
}
