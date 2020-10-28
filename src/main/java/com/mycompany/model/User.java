package com.mycompany.model;

public class User {

    private String userId;

    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public User userId(final String value) {
        this.userId = value;
        return this;
    }

    public User userName(final String value) {
        this.userName = value;
        return this;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + "]";
    }

}
