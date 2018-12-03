package com.face.project.faceid.faceid.service;

import com.face.project.faceid.faceid.model.SystemUser;

public interface SystemUserService {
    int loginCheck(Long id,String psw);

    int resetPsw(SystemUser user);
}
