package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Course implements Serializable{
    private Long courseId;
    private String courseName;
    private String pictureUrl;
    private String oneWord;
    private String introduce;
    private Long teacherId;
    private Integer courseCount;
    private BigDecimal price;
    private BigDecimal discount;
    private Byte effective;
    private Date replayDate;
    private String replayUsername;
    private Integer seq;
    private Byte chargeType;
    private Byte status;
    private String reason;

    public Course(Long courseId, String courseName, String pictureUrl, String oneWord, String introduce, Long teacherId, Integer courseCount, BigDecimal price, BigDecimal discount, Byte effective, Date replayDate, String replayUsername, Integer seq, Byte chargeType, Byte status, String reason) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.pictureUrl = pictureUrl;
        this.oneWord = oneWord;
        this.introduce = introduce;
        this.teacherId = teacherId;
        this.courseCount = courseCount;
        this.price = price;
        this.discount = discount;
        this.effective = effective;
        this.replayDate = replayDate;
        this.replayUsername = replayUsername;
        this.seq = seq;
        this.chargeType = chargeType;
        this.status = status;
        this.reason = reason;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getOneWord() {
        return oneWord;
    }

    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Integer courseCount) {
        this.courseCount = courseCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Byte getEffective() {
        return effective;
    }

    public void setEffective(Byte effective) {
        this.effective = effective;
    }

    public Date getReplayDate() {
        return replayDate;
    }

    public void setReplayDate(Date replayDate) {
        this.replayDate = replayDate;
    }

    public String getReplayUsername() {
        return replayUsername;
    }

    public void setReplayUsername(String replayUsername) {
        this.replayUsername = replayUsername;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Byte getChargeType() {
        return chargeType;
    }

    public void setChargeType(Byte chargeType) {
        this.chargeType = chargeType;
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
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", oneWord='" + oneWord + '\'' +
                ", introduce='" + introduce + '\'' +
                ", teacherId=" + teacherId +
                ", courseCount=" + courseCount +
                ", price=" + price +
                ", discount=" + discount +
                ", effective=" + effective +
                ", replayDate=" + replayDate +
                ", replayUsername='" + replayUsername + '\'' +
                ", seq=" + seq +
                ", chargeType=" + chargeType +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }
}
