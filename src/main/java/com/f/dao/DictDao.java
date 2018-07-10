package com.f.dao;

import com.f.core.pojo.Dict;

import java.util.Map;

public interface DictDao extends GenericMapper<Dict, Integer> {
    void save(Map<String, Object> map);
}
