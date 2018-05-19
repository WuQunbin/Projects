package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class CashRecord implements Serializable{
    private Long payRecordId;
    private Long userId;
    private Long courseId;
    private Long teacherId;
    private Date cashDate;
    private BigDecimal payMoney;
    private BigDecimal incomMoney;
    private Byte status;
    private String reason;

    public CashRecord(Long payRecordId, Long userId, Long courseId, Long teacherId, Date cashDate, BigDecimal payMoney, BigDecimal incomMoney, Byte status, String reason) {
        this.payRecordId = payRecordId;
        this.userId = userId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.cashDate = cashDate;
        this.payMoney = payMoney;
        this.incomMoney = incomMoney;
        this.status = status;
        this.reason = reason;
    }

    public Long getPayRecordId() {
        return payRecordId;
    }

    public void setPayRecordId(Long payRecordId) {
        this.payRecordId = payRecordId;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCashDate() {
        return cashDate;
    }

    public void setCashDate(Date cashDate) {
        this.cashDate = cashDate;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getIncomMoney() {
        return incomMoney;
    }

    public void setIncomMoney(BigDecimal incomMoney) {
        this.incomMoney = incomMoney;
    }

    public int getStatus() {
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
        return "CashRecord{" +
                "payRecordId=" + payRecordId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", cashDate=" + cashDate +
                ", payMoney=" + payMoney +
                ", incomMoney=" + incomMoney +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }
}
