package com.ax.extra.gen.generator;

import com.ax.extra.gen.model.GenScheme;

/**
 * Created by kyy on 2017/9/25.
 */
public class SchemeHelper {


    /**
     * 通过数据库表生产genSchema
     *
     * @param databaseReverser 数据库反向
     * @param dbName           数据库名称
     * @param tableName        表名称
     * @param moduleName       模块名称
     * @param subModuleName    子模块名称
     * @param replaceFile      是否替换已存在文件
     * @param plan             生成计划
     * @return
     */
    public GenScheme getSchemeFormTable(
            DatabaseReverser databaseReverser,
            String dbName, String tableName,
            String moduleName, String subModuleName, boolean replaceFile, String plan) {

        GenScheme scheme = new GenScheme();
        scheme.setModuleName(moduleName);
        scheme.setSubModuleName(subModuleName);
        scheme.setReplaceFile(replaceFile);
        scheme.setGenPlan(plan);
        scheme.setTable(databaseReverser.getTable(dbName, tableName));

        return scheme;
    }

}
