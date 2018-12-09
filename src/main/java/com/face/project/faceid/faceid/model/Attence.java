package com.face.project.faceid.faceid.model;

import java.util.Date;

public class Attence {
    private String user;
    private Date inTime;
    private Date outTime;

//    public Attence(String user, Date inTime, Date outTime) {
//        this.user = user;
//        this.inTime = inTime;
//        this.outTime = outTime;
//    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}
