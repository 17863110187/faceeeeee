package com.face.project.faceid.faceid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "")
public class IndexController {
    @RequestMapping(value = "/")
    public String Home(){
        return "login";
    }

    @RequestMapping(value = "toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "toDetailedInformation")
    public String toIndex1(){
        return "detailedInformation";
    }

    @RequestMapping(value = "toAttendanceSummary")
    public String toIndex3(){
        return "attendanceSummary";
    }

    @RequestMapping(value = "toInformationList")
    public String toIndex4(){
        return "informationList";
    }

    @RequestMapping(value = "toAddPersonnel")
    public String toIndex5(){
        return "addPersonnel";
    }

    @RequestMapping(value = "toModifyInformation")
    public String toIndex6(){
        return "modifyInformation";
    }

    @RequestMapping(value = "toChangePassword")
    public String toIndex7(){
        return "changePassword";
    }

    @RequestMapping(value = "toBrushFace")
    public String toIndex8(){
        return "brushFace";
    }

    @RequestMapping(value = "toAttendanceDetails")
    public String toIndex9(){
        return "attendanceDetails";
    }
}
