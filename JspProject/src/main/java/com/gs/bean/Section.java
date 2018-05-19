package com.gs.bean;

import java.io.Serializable;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Section implements Serializable{
    private Long sectionId;
    private Long courseId;
    private String sectionName;
    private Integer timeLength;
    private String sectionUrl;
    private String sectionContent;
    private String remark;
    private Byte free;
    private Integer seq;
    private Byte status;
    private String reason;

    public Section(Long sectionId, Long courseId, String sectionName, Integer timeLength, String sectionUrl, String sectionContent, String remark, Byte free, Integer seq, Byte status, String reason) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.sectionName = sectionName;
        this.timeLength = timeLength;
        this.sectionUrl = sectionUrl;
        this.sectionContent = sectionContent;
        this.remark = remark;
        this.free = free;
        this.seq = seq;
        this.status = status;
        this.reason = reason;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }

    public String getSectionUrl() {
        return sectionUrl;
    }

    public void setSectionUrl(String sectionUrl) {
        this.sectionUrl = sectionUrl;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getFree() {
        return free;
    }

    public void setFree(Byte free) {
        this.free = free;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
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
        return "Section{" +
                "sectionId=" + sectionId +
                ", courseId=" + courseId +
                ", sectionName='" + sectionName + '\'' +
                ", timeLength=" + timeLength +
                ", sectionUrl='" + sectionUrl + '\'' +
                ", sectionContent='" + sectionContent + '\'' +
                ", remark='" + remark + '\'' +
                ", free=" + free +
                ", seq=" + seq +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }
}
