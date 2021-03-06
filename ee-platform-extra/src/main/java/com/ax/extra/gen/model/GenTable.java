package com.ax.extra.gen.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * 表模型
 */
@Data
public class GenTable {

    private String tableName;
    private String tableComment;

    private String className;
    private String classNameFll; //fll：首字母小写 first litter lowercase

    private List<GenColumn> columns;

}
