package com.gs.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class UserCourseEval implements Serializable{
    private Long userCourseEvalId;
    private Long userId;
    private Long courseId;
    private Byte evalLevel;
    private String evalContent;
    private Date evalDate;

    public UserCourseEval(Long userCourseEvalId, Long userId, Long courseId, Byte evalLevel, String evalContent, Date evalDate) {
        this.userCourseEvalId = userCourseEvalId;
        this.userId = userId;
        this.courseId = courseId;
        this.evalLevel = evalLevel;
        this.evalContent = evalContent;
        this.evalDate = evalDate;
    }

    public Long getUserCourseEvalId() {
        return userCourseEvalId;
    }

    public void setUserCourseEvalId(Long userCourseEvalId) {
        this.userCourseEvalId = userCourseEvalId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Byte getEvalLevel() {
        return evalLevel;
    }

    public void setEvalLevel(Byte evalLevel) {
        this.evalLevel = evalLevel;
    }

    public String getEvalContent() {
        return evalContent;
    }

    public void setEvalContent(String evalContent) {
        this.evalContent = evalContent;
    }

    public Date getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }

    @Override
    public String toString() {
        return "UserCourseEval{" +
                "userCourseEvalId=" + userCourseEvalId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", evalLevel=" + evalLevel +
                ", evalContent='" + evalContent + '\'' +
                ", evalDate=" + evalDate +
                '}';
    }
}
