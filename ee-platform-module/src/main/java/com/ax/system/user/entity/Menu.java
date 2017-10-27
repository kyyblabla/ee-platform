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
@Table(name="sys_menu")
public class Menu {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String remark;
    private String icon;
    private String href;
    private Integer isHidden;
    private Long parentId;
    private Integer orderNum;
    private Long createBy;
    private Long modifyBy;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public Menu() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getIsHidden() {
        return this.isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
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
        return "Menu ("+
                "id=" + id + ", " +
                "title=" + title + ", " +
                "remark=" + remark + ", " +
                "icon=" + icon + ", " +
                "href=" + href + ", " +
                "isHidden=" + isHidden + ", " +
                "parentId=" + parentId + ", " +
                "orderNum=" + orderNum + ", " +
                "createBy=" + createBy + ", " +
                "modifyBy=" + modifyBy + ", " +
                "createTime=" + createTime + ", " +
                "modifyTime=" + modifyTime +")";
    }
}