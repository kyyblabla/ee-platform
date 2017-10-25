package com.ax.system.user.entity;

import com.ax.common.entity.TreeEntity;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class Organization extends TreeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String orgCode;

    private String orgName;

    private Long parentId;
    private Integer orderNum;

    @Override
    public String getName() {
        return getOrgName();
    }
}
