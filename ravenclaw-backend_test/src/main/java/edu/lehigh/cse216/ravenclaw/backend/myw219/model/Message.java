package edu.lehigh.cse216.ravenclaw.backend.myw219.model;

import java.util.Date;

/**
 * Creates a message class
 * The message should contain the TITLE, BODY, DATE CREATED, AND #LIKES
 */
public class Message {
    private Long userId;
    private Long messageId;
    private String title;
    private String body;

    private int likes;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
