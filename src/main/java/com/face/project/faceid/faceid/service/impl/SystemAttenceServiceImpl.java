package com.face.project.faceid.faceid.service.impl;

import com.face.project.faceid.faceid.dao.SystemAttenceDao;
import com.face.project.faceid.faceid.dao.SystemUserDao;
import com.face.project.faceid.faceid.model.SystemAttence;
import com.face.project.faceid.faceid.model.SystemAttenceSummary;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemAttenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: faceid
 * @description: 系统考勤服务层实现类
 * @author: 管庆增
 * @create: 2018-12-08 00:40
 **/
@Service
public class SystemAttenceServiceImpl implements SystemAttenceService {

    @Autowired
    private SystemUserDao systemUserDao;

    @Autowired
    private SystemAttenceDao systemAttenceDao;

    @Override
    public Map<String, Object> getAttenceSummary(String name, String department, Integer year, Integer month) {
        Long id = null;
        List<SystemAttenceSummary> summary = new ArrayList<SystemAttenceSummary>();
        SystemAttenceSummary item = null;
        if(name.length()<=0){
            List<SystemUser> employ = null;
            employ = systemUserDao.selectUserByDepart(department);
            for(SystemUser u : employ){
                item = new SystemAttenceSummary();
                item.setId(u.getId());
                item.setYear(year);
                item.setMonth(month);
                item = systemAttenceDao.selectAttenceByUser(item);
                if(item!=null){
                    item.setId(u.getId());
                    item.setName(u.getName());
                    summary.add(item);
                }
            }
        }else {
            SystemUser user = null;
            try {
                Integer.parseInt(name);
            }catch (NumberFormatException e){
                user = systemUserDao.selectUserByName(name);
                item = new SystemAttenceSummary();
                item.setId(user.getId());
                item.setYear(year);
                item.setMonth(month);
                item = systemAttenceDao.selectAttenceByUser(item);
                if(item!=null){
                    item.setId(user.getId());
                    item.setName(user.getName());
                    summary.add(item);
                }
            }
            id=Long.parseLong(name);
            user = systemUserDao.selectUserById(id);
            item = new SystemAttenceSummary();
            item.setId(user.getId());
            item.setYear(year);
            item.setMonth(month);
            item = systemAttenceDao.selectAttenceByUser(item);
            if(item!=null){
                item.setId(user.getId());
                item.setName(user.getName());
                summary.add(item);
            }
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("counts",summary.size());
        result.put("summary",summary);
        return result;
    }
}
