package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.*;

/**
 * Table Name: menu
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class Menu {

    @Id
    private Long id;
    private String menuCode;
    private String menuTitle;
    private String menuDesc;
    private String menuIcon;
    private String href;
    private String path;
    private Integer isHidden;
    private Long parentId;
    private Integer orderNum;
    private Long createBy;
    private Long modifyBy;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    public Menu() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return this.menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuTitle() {
        return this.menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuDesc() {
        return this.menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public String getMenuIcon() {
        return this.menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
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
        return "Menu" +
                "id=" + id + ", " +
                "menuCode=" + menuCode + ", " +
                "menuTitle=" + menuTitle + ", " +
                "menuDesc=" + menuDesc + ", " +
                "menuIcon=" + menuIcon + ", " +
                "href=" + href + ", " +
                "path=" + path + ", " +
                "isHidden=" + isHidden + ", " +
                "parentId=" + parentId + ", " +
                "orderNum=" + orderNum + ", " +
                "createBy=" + createBy + ", " +
                "modifyBy=" + modifyBy + ", " +
                "createTime=" + createTime + ", " +
                "modifyTime=" + modifyTime + ")";
    }
}