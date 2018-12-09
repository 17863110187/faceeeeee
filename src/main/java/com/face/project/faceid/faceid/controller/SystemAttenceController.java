package com.face.project.faceid.faceid.controller;


import com.face.project.faceid.faceid.common.*;

import com.face.project.faceid.faceid.common.ResponceMap;
import com.face.project.faceid.faceid.model.Attence;
import com.face.project.faceid.faceid.model.SystemAttence;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemAttenceService;
import com.face.project.faceid.faceid.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

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

    @Autowired
    private SystemUserService systemUserService;

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

    @RequestMapping(value = "faceCheck",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> faceCheck(String picture,HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");

        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            byte[] bytes1 = FileUtil.readFileByBytes(user.getCheckPic());
            String image1 = Base64Util.encode(bytes1);
            String image2 = picture;

            List<Map<String, Object>> images = new ArrayList<>();

            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");

            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");

            images.add(map1);
            images.add(map2);

            String param = GsonUtils.toJson(images);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.b6bdf2f4d0b00a1e4bff297a0032319c.2592000.1546849112.282335-15096727";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return ResponceMap.responceSuccess(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponceMap.responceError("未知错误");
    }

    @RequestMapping(value = "insertAttence",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertAttence(Boolean workState,HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user==null){
            return ResponceMap.responceError(ERROR_NOSESSION);
        }
        switch (systemAttenceService.insertAttence(user.getId(),workState)){
            case -1:
                return ResponceMap.responceError("打卡失败");
            case 1:
                return ResponceMap.responceSuccess("打卡成功");
            default:
        }
        return ResponceMap.responceError("打卡失败");
    }
}
