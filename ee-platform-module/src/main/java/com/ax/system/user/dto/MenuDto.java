package com.ax.system.user.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by kyy on 2017/10/26.
 */
@Data
public class MenuDto {

    private Long id;
    @NotNull
    private String menuCode;
    @NotNull
    private String menuTitle;
    private String menuDesc;
    private String menuIcon;
    private String href;
    private String path;
    private Integer isHidden;
    private Long parentId;
    private Integer orderNum;
    
}
