package com.face.project.faceid.faceid.dao;

import com.face.project.faceid.faceid.model.SystemAttendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AttendanceDetailsDao {
    List<SystemAttendance> selectAttendance(@Param("year")Integer year, @Param("month")Integer month, @Param("userid") Long userid);
    List<SystemAttendance> selectAllAttendance(@Param("userid") Long userid);
}
