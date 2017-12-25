package edu.lehigh.cse216.ravenclaw.backend.myw219.model;

import java.util.List;

/**
 * Created by Cohen on 2/25/17.
 */
public class User {
    private Long userId;
    private String username;
    private String realname;
    private String email;
    private String salt;
    private String password;
    private List<Message> upVotedMessages;
    private List<Message> downVotedMessages;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getUpVotedMessages() {
        return upVotedMessages;
    }

    public void setUpVotedMessages(List<Message> upVotedMessages) {
        this.upVotedMessages = upVotedMessages;
    }

    public List<Message> getDownVotedMessages() {
        return downVotedMessages;
    }

    public void setDownVotedMessages(List<Message> downVotedMessages) {
        this.downVotedMessages = downVotedMessages;
    }
}
