package com.gs.bean;


import java.io.Serializable;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Manager implements Serializable{
    private Long managerId;
    private String managerAccount;
    private String managerPassword;
    private String managerName;
    private Byte sex;
    private String contact;
    private Byte status;

    public Manager(Long managerId, String managerAccount, String managerPassword, String managerName, Byte sex, String contact, Byte status) {
        this.managerId = managerId;
        this.managerAccount = managerAccount;
        this.managerPassword = managerPassword;
        this.managerName = managerName;
        this.sex = sex;
        this.contact = contact;
        this.status = status;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
