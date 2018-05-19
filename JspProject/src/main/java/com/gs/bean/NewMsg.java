package com.gs.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class NewMsg implements Serializable{
    private Long newMesId;
    private String msgName;
    private String oneWord;
    private String msgContent;
    private String msgContentUrl;
    private Timestamp publishDate;
    private String publishUsername;
    private Byte effective;
    private Integer seq;
    private Byte newsType;
    private String imageUrl;

    public NewMsg(Long newMesId, String msgName, String oneWord, String msgContent, String msgContentUrl, Timestamp publishDate, String publishUsername, Byte effective, Integer seq, Byte newsType, String imageUrl) {
        this.newMesId = newMesId;
        this.msgName = msgName;
        this.oneWord = oneWord;
        this.msgContent = msgContent;
        this.msgContentUrl = msgContentUrl;
        this.publishDate = publishDate;
        this.publishUsername = publishUsername;
        this.effective = effective;
        this.seq = seq;
        this.newsType = newsType;
        this.imageUrl = imageUrl;
    }

    public Long getNewMesId() {
        return newMesId;
    }

    public void setNewMesId(Long newMesId) {
        this.newMesId = newMesId;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getOneWord() {
        return oneWord;
    }

    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getMsgContentUrl() {
        return msgContentUrl;
    }

    public void setMsgContentUrl(String msgContentUrl) {
        this.msgContentUrl = msgContentUrl;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishUsername() {
        return publishUsername;
    }

    public void setPublishUsername(String publishUsername) {
        this.publishUsername = publishUsername;
    }

    public Byte getEffective() {
        return effective;
    }

    public void setEffective(Byte effective) {
        this.effective = effective;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Byte getNewsType() {
        return newsType;
    }

    public void setNewsType(Byte newsType) {
        this.newsType = newsType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "NewMsg{" +
                "newMesId=" + newMesId +
                ", msgName='" + msgName + '\'' +
                ", oneWord='" + oneWord + '\'' +
                ", msgContent='" + msgContent + '\'' +
                ", msgContentUrl='" + msgContentUrl + '\'' +
                ", publishDate=" + publishDate +
                ", publishUsername='" + publishUsername + '\'' +
                ", effective=" + effective +
                ", seq=" + seq +
                ", newsType=" + newsType +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
