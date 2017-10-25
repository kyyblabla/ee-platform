package com.ax.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by kyy on 2017/10/11.
 */
@Data
public class BaseEntity {

    private Long id;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    
}
