package com.ax.extra.gen.convert;

/**
 * Created by kyy on 2017/9/25.
 */
public interface TypeConvert {

    /**
     * sql数据类型转化为java数据类型
     * 其中由jdk8提供日期、时间类型，不使用java.utils提供的日期时间类型
     *
     * @param sqlType
     * @return
     */
    String convertSqlTypeToJavaType(String sqlType);

    String convertJavaTypeToSqlType(String javaType);

}
