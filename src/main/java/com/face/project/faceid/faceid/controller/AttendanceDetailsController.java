package com.face.project.faceid.faceid.controller;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.model.SystemAttendance;
import com.face.project.faceid.faceid.service.AttendanceDetailsService;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "attendance")
public class AttendanceDetailsController {
    @Autowired
    private AttendanceDetailsService AttendanceDetailsService;
    @RequestMapping(value = "getAttendance")
    @ResponseBody
    public List<SystemAttendance> selectAttendanceinformation(@RequestParam(required = true) Integer year, @RequestParam(required = true) Integer month, HttpSession session) {
        SystemUser user = (SystemUser) session.getAttribute("user");
        Long userid = user.getId();
        if (year == null) {
            return null;
        }
        if (month == null) {
            return null;
        }
            return AttendanceDetailsService.selectAttendance(year, month,userid);
    }

    @RequestMapping(value = "getAllAttendance")
    @ResponseBody
    public List<SystemAttendance> selectAttendanceinformation( HttpSession session) {
        SystemUser user = (SystemUser) session.getAttribute("user");
        Long userid = user.getId();

        return AttendanceDetailsService.selectAllAttendance(userid);
    }
}




