package com.face.project.faceid.faceid.model;

/**
 * @program: faceid
 * @description: 系统权限实体类
 * @author: 管庆增
 * @create: 2018-12-05 21:30
 **/
public class SystemPermission {
    private Long id;
    private String role;
    private String permission;
    private String permissionName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
