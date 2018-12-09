package com.face.project.faceid.faceid.service;

import com.face.project.faceid.faceid.model.SystemAttendance;
import com.face.project.faceid.faceid.model.SystemUser;


import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

public interface AttendanceDetailsService {
    List<SystemAttendance> selectAttendance(Integer year, Integer month, Long userid);
    List<SystemAttendance> selectAllAttendance(Long userid);
}
