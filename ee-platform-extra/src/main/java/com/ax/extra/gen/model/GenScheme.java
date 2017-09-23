package com.ax.extra.gen.model;

import lombok.Data;

/**
 * Created by kyy on 2017/9/19.
 */
@Data
public class GenScheme {

    private String name;     // 名称
    private String packageName;     // 生成基本包路径
    private String moduleName;      // 生成模块名
    private String subModuleName;   // 生成子模块名
    private Boolean replaceFile = true;    // 是否替换现有文件
    private String className;        // 实体类名称
    private String classNameFll;     //fll：首字母小写 first litter lowercase
    private GenTable table;


    public String getClassName() {
        return className == null ? table.getClassName() : className;
    }

    public String getClassNameFll() {
        return classNameFll == null ? table.getClassNameFll() : classNameFll;
    }


}
