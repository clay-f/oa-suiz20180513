package com.f.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OutputJsonHelper {

    private static class HelpOutputJson {
        private static final ObjectMapper INSTANCE = new ObjectMapper();
    }

    public static Object outputJsonVal(Object obj) {
        Object resultObj = null;
        try {
            resultObj = HelpOutputJson.INSTANCE.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultObj;
    }


}
