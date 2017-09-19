package com.ax.extra.gen.code;

import lombok.Data;

/**
 * Created by kyy on 2017/9/19.
 */
@Data
public class GenScheme {

    private String name;     // 名称
    private String packageName;     // 生成包路径
    private String moduleName;      // 生成模块名
    private String subModuleName;   // 生成子模块名
    private Boolean replaceFile;    // 是否替换现有文件
    private String className;        // 实体类名称

    private String type; //dao dao.test service service.test controller controller.test

}
