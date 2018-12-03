package com.face.project.faceid.faceid.common;

import java.util.HashMap;
import java.util.Map;

public class ResponceMap {
    public static Map<String,Object> responceSuccess(Object o){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("success",true);
        result.put("data",o);
        return result;
    }

    public static Map<String,Object> responceSuccess(String msg){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("success",true);
        result.put("message",msg);
        return result;
    }

    public static Map<String,Object> responceError(String msg){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("success",false);
        result.put("message",msg);
        return result;
    }
}
