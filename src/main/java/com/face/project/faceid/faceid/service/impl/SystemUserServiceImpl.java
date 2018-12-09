package com.face.project.faceid.faceid.service.impl;

import com.face.project.faceid.faceid.dao.SystemAttenceDao;
import com.face.project.faceid.faceid.dao.SystemUserDao;
import com.face.project.faceid.faceid.model.SystemUser;
import com.face.project.faceid.faceid.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserDao systemUserDao;

    @Autowired
    private SystemAttenceDao systemAttenceDao;

    @Override
    public int loginCheck(Long id, String psw) {
        SystemUser user = systemUserDao.selectUserById(id);

        if(user==null){
            return -1;
        }
        if(user.getPassword().equals(psw)){
            return 1;

        }else {
            return 0;
        }
    }

    @Override
    public int resetPsw(SystemUser user) {
        return systemUserDao.updatePasswordByPhone(user);
    }

    @Override
    public SystemUser getUserById(Long id) {
        return systemUserDao.selectUserById(id);
    }

    @Override
    public boolean getWorkState(Long id) {
        int count = systemAttenceDao.selectCountForNullOut(id);
        return count > 0;
    }

    @Override
    public String getCheckPicByUser(Long id) {
        String result = systemUserDao.selectCheckPicByUser(id);
        System.out.println(result);
        return result;
    }

}
