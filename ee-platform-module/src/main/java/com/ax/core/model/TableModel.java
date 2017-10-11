package com.ax.core.model;

import lombok.Data;

/**
 * 表模型，对应数据库表
 * Created by kyy on 2017/10/11.
 */
@Data
public class TableModel {

    private String id;
    private String tableName;
    private String idColumnName;

    private String idProperty;


}
