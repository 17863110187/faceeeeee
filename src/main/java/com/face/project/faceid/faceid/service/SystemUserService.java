package com.face.project.faceid.faceid.service;

import com.face.project.faceid.faceid.model.SystemUser;

public interface SystemUserService {
    int loginCheck(Long id,String psw);

    int resetPsw(SystemUser user);

    SystemUser getUserById(Long id);

    boolean getWorkState(Long id);

    String getCheckPicByUser(Long id);
}
