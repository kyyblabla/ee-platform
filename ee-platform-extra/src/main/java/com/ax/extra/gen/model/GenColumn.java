package com.ax.extra.gen.model;

import lombok.Data;

/**
 * 列模型
 */
@Data
public class GenColumn {

    private Boolean primaryKey = false;
    private Boolean nullable = false;
    private Boolean autoIncrement = false;

    private String columnName;
    private String columnType;
    private String columnComment;

    private String attributeName;
    private String attributeNameFlu; // flu：first litter uppercase 属性名首字母大写
    private String attributeType;
    
}
