package com.f.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OutputJsonHelper {
    private static ObjectMapper objectMapper;
    private OutputJsonHelper() {
        objectMapper = new ObjectMapper();
    }

    private static class HelpOutputJson {
        private static final OutputJsonHelper INSTANCE = new OutputJsonHelper();
    }

    public static OutputJsonHelper getJsonOutputInstance() {
        return HelpOutputJson.INSTANCE;
    }

    /*
       生成格式化 json 数据
     */
    public  Object outputJsonVal(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
