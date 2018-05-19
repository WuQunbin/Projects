package com.gs.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Syslog implements Serializable{
    private Long sysLogId;
    private Long managerId;
    private String content;
    private Date createDate;
    private String ipAppress;

    public Syslog(Long sysLogId, Long managerId, String content, Date createDate, String ipAppress) {
        this.sysLogId = sysLogId;
        this.managerId = managerId;
        this.content = content;
        this.createDate = createDate;
        this.ipAppress = ipAppress;
    }

    public Long getSysLogId() {
        return sysLogId;
    }

    public void setSysLogId(Long sysLogId) {
        this.sysLogId = sysLogId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIpAppress() {
        return ipAppress;
    }

    public void setIpAppress(String ipAppress) {
        this.ipAppress = ipAppress;
    }

    @Override
    public String toString() {
        return "Syslog{" +
                "sysLogId=" + sysLogId +
                ", managerId=" + managerId +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", ipAppress='" + ipAppress + '\'' +
                '}';
    }
}
