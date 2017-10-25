package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.*;

/**
 * 
 * Table Name: organization
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class Organization {

    @Id
    private Long id;
    private String orgCode;
    private String orgName;
    private String orgType;
    private Long parentId;
    private Integer orderNum;
    private Long createBy;
    private Long modifyBy;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public Organization() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return this.orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return this.orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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


    @Override
    public String toString() {
        return "Organization"+
        "id=" + id + ", " +
        "orgCode=" + orgCode + ", " +
        "orgName=" + orgName + ", " +
        "orgType=" + orgType + ", " +
        "parentId=" + parentId + ", " +
        "orderNum=" + orderNum + ", " +
        "createBy=" + createBy + ", " +
        "modifyBy=" + modifyBy + ", " +
        "createTime=" + createTime + ", " +
        "modifyTime=" + modifyTime +")";
    }
}