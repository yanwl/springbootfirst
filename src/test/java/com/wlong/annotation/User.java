package com.wlong.annotation;

import com.wlong.util.DateFormatUtil;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class User {
    private String userId;
    private String userName;
    private String userCode;
    private Date updTime;
    private String updTimeStr;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
        this.updTimeStr = DateFormatUtil.dateToStr(updTime);
    }

    public String getUpdTimeStr() {
        return DateFormatUtil.dateToStr(updTime);
    }

    public String getUpdTimeStrByFormat(String format) {
        return DateFormatUtil.dateToStrByFormat(updTime,format);
    }


    public void setUpdTimeStr(String updTimeStr) {
        this.updTimeStr = updTimeStr;
        this.updTime=DateFormatUtil.strToDate(updTimeStr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", updTime=" + updTime +
                ", updTimeStr='" + updTimeStr + '\'' +
                '}';
    }
}
