package com.ax.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by kyy on 2017/10/11.
 */
@Data
public class ExtendEntity extends BaseEntity {

    private String createdBy;
    private String lastUpdatedBy;

    /**
     * 版本号，用于乐观锁
     */
    private Integer version;

    /**
     * 删除标记
     */
    private Boolean deleted;

    
}
