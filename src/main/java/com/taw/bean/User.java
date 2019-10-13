package com.taw.bean;

public class User {

    private Integer uid;
    private String loginName;
    private String password;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private String descip;
    private String role;
    private Dept dept;
    private Integer did;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescip() {
        return descip;
    }

    public void setDescip(String descip) {
        this.descip = descip;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public User(Integer uid, String loginName, String password, String name, String sex, String phone, String email, String descip, String role, Dept dept, Integer did) {
        this.uid = uid;
        this.loginName = loginName;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.descip = descip;
        this.role = role;
        this.dept = dept;
        this.did = did;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", descip='" + descip + '\'' +
                ", role='" + role + '\'' +
                ", dept=" + dept +
                '}';
    }
}
