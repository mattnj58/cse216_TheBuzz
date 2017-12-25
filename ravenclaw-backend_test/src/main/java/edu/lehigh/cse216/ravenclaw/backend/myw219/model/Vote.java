package edu.lehigh.cse216.ravenclaw.backend.myw219.model;

/**
 * Created by Cohen on 2/25/17.
 */
public class Vote {
    private Long userId;
    private Long messageId;
    private boolean upVote;

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

    public boolean isUpVote() {
        return upVote;
    }

    public void setUpVote(boolean upVote) {
        this.upVote = upVote;
    }
}
