package com.gs.bean;



import java.io.Serializable;
import java.util.Date;

/**
 * @author:伍群斌
 * @description:
 * @date:2018/5/19 12:05
 */
public class Forum implements Serializable {
    private Long forumId;
    private Long userId;
    private Long replayUserId;
    private Byte fourmType;
    private String content;
    private Date forumDate;

    public Forum(Long forumId, Long userId, Long replayUserId, Byte fourmType, String content, Date forumDate) {
        this.forumId = forumId;
        this.userId = userId;
        this.replayUserId = replayUserId;
        this.fourmType = fourmType;
        this.content = content;
        this.forumDate = forumDate;
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReplayUserId() {
        return replayUserId;
    }

    public void setReplayUserId(Long replayUserId) {
        this.replayUserId = replayUserId;
    }

    public Byte getFourmType() {
        return fourmType;
    }

    public void setFourmType(Byte fourmType) {
        this.fourmType = fourmType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getForumDate() {
        return forumDate;
    }

    public void setForumDate(Date forumDate) {
        this.forumDate = forumDate;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", userId=" + userId +
                ", replayUserId=" + replayUserId +
                ", fourmType=" + fourmType +
                ", content='" + content + '\'' +
                ", forumDate=" + forumDate +
                '}';
    }
}
