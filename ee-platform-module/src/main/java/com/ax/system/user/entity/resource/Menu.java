package com.ax.system.user.entity.resource;

import lombok.Data;

/**
 * Created by kyy on 2017/10/24.
 */
@Data
public class Menu {

    private Long id;
    private String code;
    private String title;
    private Long parentId;
    private String path;
    private String href;
    private String icon;
    private String type;
    private String description;
    private String orderNum;

}
