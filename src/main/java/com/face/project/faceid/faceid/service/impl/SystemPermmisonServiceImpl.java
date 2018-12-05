package com.face.project.faceid.faceid.service.impl;

import com.face.project.faceid.faceid.dao.SystemPermissionDao;
import com.face.project.faceid.faceid.model.SystemPermission;
import com.face.project.faceid.faceid.service.SystemPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: faceid
 * @description: 系统权限服务层实现类
 * @author: 管庆增
 * @create: 2018-12-05 19:47
 **/
@Service
public class SystemPermmisonServiceImpl implements SystemPermissionService{
    @Autowired
    private SystemPermissionDao systemPermissionDao;
    @Override
    public Map<String,Object> getPermission(String role) {
        List<SystemPermission> permission =  systemPermissionDao.selectPermission(role);
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("permission",permission);
        result.put("counts",permission.size());
        return result;
    }
}
