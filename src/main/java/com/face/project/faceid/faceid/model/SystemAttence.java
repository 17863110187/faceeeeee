package com.face.project.faceid.faceid.model;

import java.util.Date;

/**
 * @program: faceid
 * @description: 系统考勤详情实体类
 * @author: 管庆增
 * @create: 2018-12-08 00:58
 **/
public class SystemAttence {
    private Long id;
    private Long user;
    private String name;
    private Date inTime;
    private Date outTime;
    private String inPic;
    private String outPic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getInPic() {
        return inPic;
    }

    public void setInPic(String inPic) {
        this.inPic = inPic;
    }

    public String getOutPic() {
        return outPic;
    }

    public void setOutPic(String outPic) {
        this.outPic = outPic;
    }
}
