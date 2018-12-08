package com.face.project.faceid.faceid.controller;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.model.Attence;
import com.face.project.faceid.faceid.model.SystemAttence;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemAttenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.face.project.faceid.faceid.common.ConstMap.*;

/**
 * @program: faceid
 * @description: 系统考勤控制层
 * @author: 管庆增
 * @create: 2018-12-08 00:20
 **/
@Controller
@RequestMapping(value = "attence")
public class SystemAttenceController {

    @Autowired
    private SystemAttenceService systemAttenceService;

    @RequestMapping(value = "selectAttence")
    @ResponseBody
    public List<SystemAttence> selectAttence(@RequestBody Attence attence) {
        if(attence == null){
            return systemAttenceService.selectAttence(null, null, null);
        }else {
            return systemAttenceService.selectAttence(attence.getUser(), attence.getInTime(), attence.getOutTime());
        }
    }

    @RequestMapping(value = "getAttenceSummary")
    @ResponseBody
    public Map<String,Object> getAttenceSummary(String name, String department, Integer year, Integer month, HttpSession session){
        if(name==null)
            name="";
        if(department!=null){
            try{
                Integer.parseInt(department);
            }catch (NumberFormatException e){
                return ResponceMap.responceError(ERROR_INPUT);
            }
        }
        if(year!=null){
            if(year<2000||year>3000){
                return ResponceMap.responceError(ERROR_INPUT);
            }
        }
        if(month!=null){
            if(month<1||month>12){
                return ResponceMap.responceError(ERROR_INPUT);
            }
        }
        SystemUser user = (SystemUser)session.getAttribute("user");
        if(user==null){
            return ResponceMap.responceError(ERROR_NOSESSION);
        }
        if(user.getRole().equals(ROLE_USER)){
            return ResponceMap.responceError(ERROR_NOPERMISSION);
        }else if(user.getRole().equals(ROLE_MANAGER)){
            return ResponceMap.responceSuccess(systemAttenceService.getAttenceSummary(name, user.getDepart(), year, month));
        }else if(user.getRole().equals(ROLE_SYSTEMMANAGER)){
            if(department==null){
                return ResponceMap.responceSuccess(systemAttenceService.getAttenceSummary(name, user.getDepart(), year, month));
            }
            return ResponceMap.responceSuccess(systemAttenceService.getAttenceSummary(name, department, year, month));
        }
        return ResponceMap.responceError(ERROR_UNKOWN);
    }
}
