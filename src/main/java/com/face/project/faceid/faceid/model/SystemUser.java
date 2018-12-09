package com.face.project.faceid.faceid.model;

public class SystemUser {
    private Long id;
    private String name;
    private String password;;
    private String role;
    private String state;
    private String depart;
    private Long phone;
    private String checkPic;

    private  String address;
    private  String email;

    public SystemUser(Long id, String name, String password, String role, String state, String depart, Long phone, String checkPic, String address, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.state = state;
        this.depart = depart;
        this.phone = phone;
        this.checkPic = checkPic;
        this.address = address;
        this.email = email;
    }

    public SystemUser(Long id, String password, Long phone){
        this.id = id;
        this.password = password;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getCheckPic() {
        return checkPic;
    }

    public void setCheckPic(String checkPic) {
        this.checkPic = checkPic;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", state='" + state + '\'' +
                ", depart='" + depart + '\'' +
                ", phone=" + phone +
                ", checkPic='" + checkPic + '\'' +
                '}';
    }
}
