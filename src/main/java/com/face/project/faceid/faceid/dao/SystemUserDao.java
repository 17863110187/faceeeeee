package com.face.project.faceid.faceid.dao;

import com.face.project.faceid.faceid.model.SystemUser;

import java.util.List;

public interface SystemUserDao {
    SystemUser selectUserById(Long id);

    SystemUser selectUserByName(String name);

    int updatePasswordByPhone(SystemUser user);

    List<SystemUser> selectUserByDepart(String department);

    String selectCheckPicByUser(Long id);
}
