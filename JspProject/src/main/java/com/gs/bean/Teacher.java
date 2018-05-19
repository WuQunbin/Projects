package com.gs.bean;

import java.io.Serializable;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Teacher implements Serializable{
    private Long teacherId;
    private String teacherIntroduce;
    private String teacherSpecial;
    private String teacherLength;
    private String education;
    private String headPictureUrl;
    private Long bankId;
    private String accountNo;
    private String accountName;
    private Long gradeId;
    private Byte status;
    private String reason;

    public Teacher(Long teacherId, String teacherIntroduce, String teacherSpecial, String teacherLength, String education, String headPictureUrl, Long bankId, String accountNo, String accountName, Long gradeId, Byte status, String reason) {
        this.teacherId = teacherId;
        this.teacherIntroduce = teacherIntroduce;
        this.teacherSpecial = teacherSpecial;
        this.teacherLength = teacherLength;
        this.education = education;
        this.headPictureUrl = headPictureUrl;
        this.bankId = bankId;
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.gradeId = gradeId;
        this.status = status;
        this.reason = reason;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherIntroduce() {
        return teacherIntroduce;
    }

    public void setTeacherIntroduce(String teacherIntroduce) {
        this.teacherIntroduce = teacherIntroduce;
    }

    public String getTeacherSpecial() {
        return teacherSpecial;
    }

    public void setTeacherSpecial(String teacherSpecial) {
        this.teacherSpecial = teacherSpecial;
    }

    public String getTeacherLength() {
        return teacherLength;
    }

    public void setTeacherLength(String teacherLength) {
        this.teacherLength = teacherLength;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHeadPictureUrl() {
        return headPictureUrl;
    }

    public void setHeadPictureUrl(String headPictureUrl) {
        this.headPictureUrl = headPictureUrl;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherIntroduce='" + teacherIntroduce + '\'' +
                ", teacherSpecial='" + teacherSpecial + '\'' +
                ", teacherLength='" + teacherLength + '\'' +
                ", education='" + education + '\'' +
                ", headPictureUrl='" + headPictureUrl + '\'' +
                ", bankId=" + bankId +
                ", accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", gradeId=" + gradeId +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }
}
