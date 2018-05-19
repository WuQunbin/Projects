package com.gs.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class ExchangeCode implements Serializable{
    private Long exchangeCodeId;
    private Long exchangeRecordId;
    private Long userId;
    private String exchangeCode;
    private BigDecimal exchangeMoney;
    private Byte exchangeStatus;
    private Date exchangeDate;


    public ExchangeCode(Long exchangeCodeId, Long exchangeRecordId, Long userId, String exchangeCode, BigDecimal exchangeMoney, Byte exchangeStatus, Date exchangeDate) {
        this.exchangeCodeId = exchangeCodeId;
        this.exchangeRecordId = exchangeRecordId;
        this.userId = userId;
        this.exchangeCode = exchangeCode;
        this.exchangeMoney = exchangeMoney;
        this.exchangeStatus = exchangeStatus;
        this.exchangeDate = exchangeDate;
    }

    public Long getExchangeCodeId() {
        return exchangeCodeId;
    }

    public void setExchangeCodeId(Long exchangeCodeId) {
        this.exchangeCodeId = exchangeCodeId;
    }

    public Long getExchangeRecordId() {
        return exchangeRecordId;
    }

    public void setExchangeRecordId(Long exchangeRecordId) {
        this.exchangeRecordId = exchangeRecordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }


    public void setExchangeMoney(BigDecimal exchangeMoney) {
        this.exchangeMoney = exchangeMoney;
    }

    public BigDecimal getExchangeMoney() {
        return exchangeMoney;
    }

    public Byte getExchangeStatus() {
        return exchangeStatus;
    }

    public void setExchangeStatus(Byte exchangeStatus) {
        this.exchangeStatus = exchangeStatus;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public String toString() {
        return "ExchangeCode{" +
                "exchangeCodeId=" + exchangeCodeId +
                ", exchangeRecordId=" + exchangeRecordId +
                ", userId=" + userId +
                ", exchangeCode='" + exchangeCode + '\'' +
                ", exchangeMoney=" + exchangeMoney +
                ", exchangeStatus=" + exchangeStatus +
                ", exchangeDate=" + exchangeDate +
                '}';
    }
}
