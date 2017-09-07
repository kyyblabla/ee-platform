package com.ax.common.dto;

import lombok.Data;

/**
 * 分页参数
 * Created by kyy on 2017/9/7.
 */
@Data
public class PageParam {

    private int pageNum = 1;
    private int pageSize = 10;

}
