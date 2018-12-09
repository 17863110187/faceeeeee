package com.face.project.faceid.faceid.model;

public class ChangePassword {
    private String oldpsd;
    private String newpsd;

    public ChangePassword(String oldpsd, String newpsd){
        this.newpsd = newpsd;
        this.oldpsd = oldpsd;
    }

    public String getOldpsd() {
        return oldpsd;
    }

    public void setOldpsd(String oldpsd) {
        this.oldpsd = oldpsd;
    }

    public String getNewpsd() {
        return newpsd;
    }

    public void setNewpsd(String newpsd) {
        this.newpsd = newpsd;
    }
}
