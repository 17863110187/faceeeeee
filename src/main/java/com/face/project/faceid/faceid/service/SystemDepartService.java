package com.face.project.faceid.faceid.service;

import com.face.project.faceid.faceid.model.SystemDepart;

import java.util.List;
import java.util.Map;

/**
 * @program: faceid
 * @description: 系统部门服务层
 * @author: 管庆增
 * @create: 2018-12-07 00:57
 **/
public interface SystemDepartService {
    public Map<String,Object> getDepartmentByCompany(String company);
}
