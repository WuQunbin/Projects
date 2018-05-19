package com.gs.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class ExchangeRecord implements Serializable{
    private Long exchangeRecordId;
    private String activityName;
    private String activityDesc;
    private Long userId;
    private Date createDate;

    public ExchangeRecord(Long exchangeRecordId, String activityName, String activityDesc, Long userId, Date createDate) {
        this.exchangeRecordId = exchangeRecordId;
        this.activityName = activityName;
        this.activityDesc = activityDesc;
        this.userId = userId;
        this.createDate = createDate;
    }

    public Long getExchangeRecordId() {
        return exchangeRecordId;
    }

    public void setExchangeRecordId(Long exchangeRecordId) {
        this.exchangeRecordId = exchangeRecordId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "ExchangeRecord{" +
                "exchangeRecordId=" + exchangeRecordId +
                ", activityName='" + activityName + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", userId=" + userId +
                ", createDate=" + createDate +
                '}';
    }
}
