package com.f.services;

import com.f.core.pojo.Dict;

import java.util.Map;

public interface DictService extends GenericService<Dict, Long> {
    void save(Dict dict, Long dictTypeId);
}
