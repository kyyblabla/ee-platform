package com.ax.extra.gen.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kyy on 2017/9/19.
 */
@Data
@XmlRootElement(name = "scheme")
public class GenScheme {

    private String name;     // 名称
    private String packageName;     // 生成基本包路径
    private String moduleName;      // 生成模块名
    private String subModuleName;   // 生成子模块名
    private Boolean replaceFile = true;    // 是否替换现有文件
    private String genPlan; //生成方案

    private Boolean directCreateFile = false;//是否直接生成文件

    private GenTable table;


    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlAttribute
    public String getPackageName() {
        return packageName;
    }

    @XmlAttribute
    public String getModuleName() {
        return moduleName;
    }

    @XmlAttribute
    public String getSubModuleName() {
        return subModuleName;
    }

    @XmlAttribute
    public Boolean getReplaceFile() {
        return replaceFile;
    }

    @XmlAttribute
    public String getGenPlan() {
        return genPlan;
    }

}
