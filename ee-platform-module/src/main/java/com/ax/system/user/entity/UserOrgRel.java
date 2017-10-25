package com.ax.system.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.*;

/**
 * Table Name: user_org_rel
 * Created by AxCodeGen on 2017/10/25.
 */
@Entity
public class UserOrgRel {

    @Id
    private Long id;
    private Long userId;
    private Long orgId;
    private Long createBy;
    private LocalDateTime createTime;

    public UserOrgRel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "UserOrgRel" +
                "id=" + id + ", " +
                "userId=" + userId + ", " +
                "orgId=" + orgId + ", " +
                "createBy=" + createBy + ", " +
                "createTime=" + createTime + ")";
    }
}