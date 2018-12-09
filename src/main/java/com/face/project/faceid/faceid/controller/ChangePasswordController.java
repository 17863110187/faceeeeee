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
@RequestMapping(value = "changepwd")
public class ChangePasswordController {
    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping(value = "changePsw")
    @ResponseBody
    public Map<String,Object> changePsw(HttpSession session, @RequestParam(required = true)String oldPasswords ,@RequestParam(required = true)String password,@RequestParam(required = true)String confirm){
        if (oldPasswords==null){
            return ResponceMap.responceError("旧密码不能为空");
        }
        if (password==null){
            return ResponceMap.responceError("新密码不能为空");
        }
        if (confirm==null||"".equals(confirm.trim())){
            return  ResponceMap.responceError("请再次确认密码");
        }
        if (!confirm.equals(password)){
            return  ResponceMap.responceError("请再次确认密码,两次密码输入不同！");
        }
        SystemUser user = (SystemUser) session.getAttribute("user");
        user.setPassword(password);
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
