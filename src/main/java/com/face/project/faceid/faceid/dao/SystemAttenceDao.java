package com.face.project.faceid.faceid.dao;

import com.face.project.faceid.faceid.model.SystemAttence;
import com.face.project.faceid.faceid.model.SystemAttenceSummary;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @program: faceid
 * @description: 系统考勤Dao层
 * @author: 管庆增
 * @create: 2018-12-08 01:10
 **/
public interface SystemAttenceDao {
    SystemAttenceSummary selectAttenceByUser(SystemAttenceSummary summary);

    List<SystemAttence> selectAttence(@Param("userId")Long userId, @Param("userName")String userName, @Param("inTime")Date inTime, @Param("outTime")Date outTime);
}
