package com.face.project.faceid.faceid.dao;

import com.face.project.faceid.faceid.model.SystemPermission;

import java.util.List;

/**
 * @program: faceid
 * @description: 系统权限Dao层
 * @author: 管庆增
 * @create: 2018-12-05 19:50
 **/
public interface SystemPermissionDao {
    List<SystemPermission> selectPermission(String role);
}
