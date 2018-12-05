package com.face.project.faceid.faceid.service;

import com.face.project.faceid.faceid.model.SystemPermission;

import java.util.List;
import java.util.Map;

/**
 * @program: faceid
 * @description: 系统权限服务类
 * @author: 管庆增
 * @create: 2018-12-05 19:46
 **/
public interface SystemPermissionService {
    public Map<String,Object> getPermission(String role);
}
