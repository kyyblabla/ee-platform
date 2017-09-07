package com.ax.dto;

import lombok.Data;

/**
 * 分页排序参数
 * Created by kyy on 2017/9/7.
 */
@Data
public class PageSortParam extends PageParam {

    public static final String SORT_ASC = "asc";
    public static final String SORT_DESC = "desc";

    private String by;
    private String sort; //asc、desc


}
