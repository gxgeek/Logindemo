package com.gx.model;


import java.io.Serializable;

/**
 * Created by gx on 2016/12/22.
 */
public class User  implements Serializable{
    private Integer userId;
    private String userName;
    private String userPassWord;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                '}';
    }

}
