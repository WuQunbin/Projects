package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author:伍群斌
 * @description:
 * @date :2018/5/19 12:05
 */
public class Users implements Serializable{
    private Long userId;
    private String phone;
    private String password;
    private String userName;
    private Byte sex;
    private String homeAddress;
    private String email;
    private Timestamp registerData;
    private Long provinceId;
    private Long cityId;
    private Long userType;
    private BigDecimal remainMoney;

    public Users(Long userId, String phone, String password, String userName, Byte sex, String homeAddress, String email, Timestamp registerData, Long provinceId, Long cityId, Long userType, BigDecimal remainMoney) {
        this.userId = userId;
        this.phone = phone;
        this.password = password;
        this.userName = userName;
        this.sex = sex;
        this.homeAddress = homeAddress;
        this.email = email;
        this.registerData = registerData;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.userType = userType;
        this.remainMoney = remainMoney;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getRegisterData() {
        return registerData;
    }

    public void setRegisterData(Timestamp registerData) {
        this.registerData = registerData;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getUserType() {
        return userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }

    public BigDecimal getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(BigDecimal remainMoney) {
        this.remainMoney = remainMoney;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", homeAddress='" + homeAddress + '\'' +
                ", email='" + email + '\'' +
                ", registerData=" + registerData +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", userType=" + userType +
                ", remainMoney=" + remainMoney +
                '}';
    }
}
