package com.ax.common.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by kyy on 2017/10/11.
 */
@Data
public class BaseEntity {

    private LocalDateTime created;
    private LocalDateTime lastUpdated;

    private Long createdBy;
    private Long lastUpdatedBy;

}
