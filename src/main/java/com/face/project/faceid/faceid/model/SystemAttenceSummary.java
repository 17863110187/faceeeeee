package com.face.project.faceid.faceid.model;

/**
 * @program: faceid
 * @description: 系统考勤汇总实体类
 * @author: 管庆增
 * @create: 2018-12-08 00:41
 **/
public class SystemAttenceSummary {
    private Long id;
    private String name;
    private Long time;
    private Integer year;
    private Integer month;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
