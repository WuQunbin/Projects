package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class MoneyRecord implements Serializable{
    private Long recordId;
    private Long userId;
    private Date payDate;
    private BigDecimal payMoney;

    public MoneyRecord(Long recordId, Long userId, Date payDate, BigDecimal payMoney) {
        this.recordId = recordId;
        this.userId = userId;
        this.payDate = payDate;
        this.payMoney = payMoney;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    @Override
    public String toString() {
        return "MoneyRecord{" +
                "recordId=" + recordId +
                ", userId=" + userId +
                ", payDate=" + payDate +
                ", payMoney=" + payMoney +
                '}';
    }
}
