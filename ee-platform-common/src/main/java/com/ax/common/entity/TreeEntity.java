package com.ax.common.entity;

import lombok.Data;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class TreeEntity extends BaseEntity {

    private Long parentId;
    private Integer orderNum;
    private String name;

}
