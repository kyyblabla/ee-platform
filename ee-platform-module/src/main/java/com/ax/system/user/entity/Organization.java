package com.ax.system.user.entity;

import java.time.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

/**
 * 
 * Created by AxCodeGen on 2017/10/27.
 */
@Entity
@Table(name="sys_organization")
public class Organization {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Organization ("+
                "id=" + id + ", " +
                "name=" + name + ", " +
                "type=" + type + ", " +
                "parentId=" + parentId + ", " +
                "orderNum=" + orderNum + ", " +
                "createBy=" + createBy + ", " +
                "modifyBy=" + modifyBy + ", " +
                "createTime=" + createTime + ", " +
                "modifyTime=" + modifyTime +")";
    }
}