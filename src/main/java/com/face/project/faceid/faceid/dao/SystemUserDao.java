package com.face.project.faceid.faceid.dao;

import com.face.project.faceid.faceid.model.SystemUser;

import java.util.List;

public interface SystemUserDao {
    SystemUser selectUserById(Long id);

    int updatePasswordByPhone(SystemUser user);
}
