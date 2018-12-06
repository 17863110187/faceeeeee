package com.face.project.faceid.faceid.service.impl;

import com.face.project.faceid.faceid.dao.SystemDepartDao;
import com.face.project.faceid.faceid.model.SystemDepart;
import com.face.project.faceid.faceid.service.SystemDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: faceid
 * @description: 系统部门服务层实现类
 * @author: 管庆增
 * @create: 2018-12-07 00:58
 **/
@Service
public class SystemDepartServiceImpl implements SystemDepartService {
    @Autowired
    private SystemDepartDao systemDepartDao;

    @Override
    public Map<String,Object> getDepartmentByCompany(String company) {
        List<SystemDepart> depts = systemDepartDao.selectDepartByCompany(company);
        for(int i=0;i<depts.size();i++){
            if(depts.get(i).getDepartment().equals(depts.get(i).getCompany())){
                depts.remove(i);
                break;
            }
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("counts",depts.size());
        result.put("departs",depts);
        return result;
    }
}
