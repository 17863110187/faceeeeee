package com.face.project.faceid.faceid.controller;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping(value = "login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required = true)Long id, @RequestParam(required = true)String psw, HttpSession session){
        if (id==null){
            return ResponceMap.responceError("账号不能为空");
        }
        if (psw==null||"".equals(psw.trim())){
            return  ResponceMap.responceError("密码不能为空");
        }

        switch (systemUserService.loginCheck(id, psw)){
            case -1:
                return  ResponceMap.responceError("该账号不存在");
            case 0:
                return  ResponceMap.responceError("密码错误");
            case 1:
                SystemUser user = systemUserService.getUserById(id);
                session.setAttribute("user",user);
                return  ResponceMap.responceSuccess("登陆成功");
        }
        return ResponceMap.responceSuccess("登陆成功");
    }

    @RequestMapping(value = "forgetPsw")
    public String forgetPsw(){
        return "forgetPsw";
    }

    @RequestMapping(value = "resetPsw")
    @ResponseBody
    public Map<String,Object> resetPsw(@RequestParam(required = true)Long id ,@RequestParam(required = true)Long phone, @RequestParam(required = true)String password,@RequestParam(required = true)String confirm){
        if (id==null){
            return ResponceMap.responceError("账号不能为空");
        }
        if (phone==null){
            return ResponceMap.responceError("手机号不能为空");
        }
        if (password==null||"".equals(password.trim())){
            return  ResponceMap.responceError("新密码不能为空");
        }
        if (confirm==null||"".equals(password.trim())){
            return  ResponceMap.responceError("请再次确认密码");
        }
        SystemUser user = new SystemUser(id, password, phone);
        if(password.equals(confirm)){
            switch (systemUserService.resetPsw(user)){
                case 0:
                    return  ResponceMap.responceError("账号不存在");
                case 1:
                    return ResponceMap.responceSuccess("修改成功");
                default:
                    return  ResponceMap.responceError("修改失败");
            }
        }
        return ResponceMap.responceError("确认密码与新密码不一致");
    }
}
