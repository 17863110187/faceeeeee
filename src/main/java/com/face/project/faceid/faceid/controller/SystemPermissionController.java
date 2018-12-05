package com.face.project.faceid.faceid.controller;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: faceid
 * @description: 系统权限控制类
 * @author: 管庆增
 * @create: 2018-12-05 19:32
 **/
@Controller
@RequestMapping(value = "permission")
public class SystemPermissionController {

    @Autowired
    private SystemPermissionService systemPermissionService;

    @RequestMapping(value = "getPermission", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getPermission(HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null){
            return ResponceMap.responceError("登录已超时");
        }
        return ResponceMap.responceSuccess(systemPermissionService.getPermission(user.getRole()));
//        return ResponceMap.responceSuccess("helo");
    }
}
