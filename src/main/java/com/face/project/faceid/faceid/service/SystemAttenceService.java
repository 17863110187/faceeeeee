package com.face.project.faceid.faceid.service;

import java.util.Map;

/**
 * @program: faceid
 * @description: 系统考勤服务层
 * @author: 管庆增
 * @create: 2018-12-08 00:40
 **/
public interface SystemAttenceService {
    Map<String,Object> getAttenceSummary(String name, String department, Integer year, Integer month);
}
