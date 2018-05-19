package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class PayRecord implements Serializable{
    private Long payRecordId;
    private Long userId;
    private Long courseId;
    private Date payDate;
    private BigDecimal payMoney;
    private BigDecimal discountMoney;
    private String payer;

    public PayRecord(Long payRecordId, Long userId, Long courseId, Date payDate, BigDecimal payMoney, BigDecimal discountMoney, String payer) {
        this.payRecordId = payRecordId;
        this.userId = userId;
        this.courseId = courseId;
        this.payDate = payDate;
        this.payMoney = payMoney;
        this.discountMoney = discountMoney;
        this.payer = payer;
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

    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "PayRecord{" +
                "payRecordId=" + payRecordId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", payDate=" + payDate +
                ", payMoney=" + payMoney +
                ", discountMoney=" + discountMoney +
                ", payer='" + payer + '\'' +
                '}';
    }
}
