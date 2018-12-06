package com.face.project.faceid.faceid.controller;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.model.SystemDepart;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static com.face.project.faceid.faceid.common.ConstMap.*;

/**
 * @program: faceid
 * @description: 系统部门控制层
 * @author: 管庆增
 * @create: 2018-12-07 00:47
 **/
@Controller
@RequestMapping(value = "department")
public class SystemDepartController {

    @Autowired
    private SystemDepartService systemDepartService;

    @RequestMapping(value = "getDepartment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getDepartment(HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null){
            return ResponceMap.responceError(ERROR_NOSESSION);
        }
        if(!user.getRole().equals(ROLE_SYSTEMMANAGER)){
            return ResponceMap.responceError(ERROR_NOPERMISSION);
        }
        Map<String,Object> result = systemDepartService.getDepartmentByCompany(user.getDepart());
        if(result.get("counts").equals(0)){
            return ResponceMap.responceError(ERROR_UNKOWN);
        }
        return ResponceMap.responceSuccess(result);
    }
}
