package com.face.project.faceid.faceid.model;

import java.util.Date;

/**
 * @program: faceid
 * @description: 系统部门实体类
 * @author: 管庆增
 * @create: 2018-12-07 00:59
 **/
public class SystemDepart {
    private Long id;
    private String department;
    private String deptName;
    private String company;
    private Date usetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getUsetime() {
        return usetime;
    }

    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }
}
