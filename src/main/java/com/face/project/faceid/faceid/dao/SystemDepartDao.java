package com.face.project.faceid.faceid.dao;

import com.face.project.faceid.faceid.model.SystemDepart;

import java.util.List;

/**
 * @program: faceid
 * @description: 系统部门dao层
 * @author: 管庆增
 * @create: 2018-12-07 01:03
 **/
public interface SystemDepartDao {
    List<SystemDepart> selectDepartByCompany(String company);
}
