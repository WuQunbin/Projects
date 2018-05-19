package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class TeacherGrade implements Serializable{
    private Long gradeId;
    private String gradeName;
    private BigDecimal gradePercent;

    public TeacherGrade(Long gradeId, String gradeName, BigDecimal gradePercent) {
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.gradePercent = gradePercent;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public BigDecimal getGradePercent() {
        return gradePercent;
    }

    public void setGradePercent(BigDecimal gradePercent) {
        this.gradePercent = gradePercent;
    }

    @Override
    public String toString() {
        return "TeacherGrade{" +
                "gradeId=" + gradeId +
                ", gradeName='" + gradeName + '\'' +
                ", gradePercent=" + gradePercent +
                '}';
    }
}
