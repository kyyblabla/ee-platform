package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.*;

/**
 * Table Name: user
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String realName;
    private String userName;
    private String passowrd;
    private Integer loginTimes;
    private Instant lastLogin;
    private Integer isEnable;
    private Integer orderNum;
    private Long createBy;
    private Long modifyBy;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassowrd() {
        return this.passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public Integer getLoginTimes() {
        return this.loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public Instant getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getIsEnable() {
        return this.isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getModifyBy() {
        return this.modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }


    public String toString() {
        return "User" +
                "id=" + id + ", " +
                "realName=" + realName + ", " +
                "userName=" + userName + ", " +
                "passowrd=" + passowrd + ", " +
                "loginTimes=" + loginTimes + ", " +
                "lastLogin=" + lastLogin + ", " +
                "isEnable=" + isEnable + ", " +
                "orderNum=" + orderNum + ", " +
                "createBy=" + createBy + ", " +
                "modifyBy=" + modifyBy + ", " +
                "createTime=" + createTime + ", " +
                "modifyTime=" + modifyTime + ")";
    }
}