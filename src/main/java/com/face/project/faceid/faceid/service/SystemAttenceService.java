package com.face.project.faceid.faceid.service;

import com.face.project.faceid.faceid.model.SystemAttence;
import com.face.project.faceid.faceid.model.SystemUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Date;
import java.util.List;

/**
 * @program: faceid
 * @description: 系统考勤服务层
 * @author: 管庆增
 * @create: 2018-12-08 00:40
 **/
public interface SystemAttenceService {
    List<SystemAttence> selectAttence(String user, Date inTime, Date outTime);

    Map<String,Object> getAttenceSummary(String name, String department, Integer year, Integer month);

    int insertAttence(Long id,Boolean workstate);
}
