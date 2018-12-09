package com.face.project.faceid.faceid.service.impl;

import com.face.project.faceid.faceid.dao.SystemPermissionDao;
import com.face.project.faceid.faceid.dao.SystemUserDao;
import com.face.project.faceid.faceid.dao.AttendanceDetailsDao;
import com.face.project.faceid.faceid.model.SystemPermission;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.AttendanceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import com.face.project.faceid.faceid.model.SystemAttendance;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Service
public class AttendanceDetailsServicelmpl implements AttendanceDetailsService {
    @Autowired
    private AttendanceDetailsDao AttendanceDetailsDao;

    @Override
    public List<SystemAttendance> selectAttendance(Integer year, Integer month, Long userid) {

        if(year==null){
            return null;
        }
        if(month==null){
            return null;
        }else {
            List<SystemAttendance> attendance =  AttendanceDetailsDao.selectAttendance(year,month,userid);
            return attendance;
        }

    }

    public List<SystemAttendance> selectAllAttendance(Long userid) {

            List<SystemAttendance> attendance =  AttendanceDetailsDao.selectAllAttendance(userid);
            return attendance;


    }
}
