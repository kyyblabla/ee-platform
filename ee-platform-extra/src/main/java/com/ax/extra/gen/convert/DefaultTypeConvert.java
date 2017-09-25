package com.ax.extra.gen.convert;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by kyy on 2017/9/25.
 */
public class DefaultTypeConvert implements TypeConvert {


    @Override
    public String convertSqlTypeToJavaType(String sqlType) {

        if (StringUtils.isBlank(sqlType)) {
            return "";
        }
        String javaType = "";
        String sqlTypeStr = sqlType.trim().toLowerCase();
        if (sqlTypeStr.equals("int")) {
            javaType = "Integer";
        } else if (sqlTypeStr.equals("char")) {
            javaType = "String";
        } else if (sqlTypeStr.equals("text")) {
            javaType = "String";
        } else if (sqlTypeStr.equals("number")) {
            javaType = "Integer";
        } else if (sqlTypeStr.indexOf("varchar") != -1) {
            javaType = "String";
        } else if (sqlTypeStr.equals("blob")) {
            javaType = "Byte[]";
        } else if (sqlTypeStr.equals("float")) {
            javaType = "Float";
        } else if (sqlTypeStr.equals("double")) {
            javaType = "Double";
        } else if (sqlTypeStr.equals("decimal")) {
            javaType = "BigDecimal";
        } else if (sqlTypeStr.equals("bigint")) {
            javaType = "Long";
        } else if (sqlTypeStr.equals("date")) {
            javaType = "LocalDate";
        } else if (sqlTypeStr.equals("time")) {
            javaType = "LocalTime";
        } else if (sqlTypeStr.equals("datetime")) {
            javaType = "LocalDateTime";
        } else if (sqlTypeStr.equals("timestamp")) {
            javaType = "Instant";
        } else if (sqlTypeStr.equals("year")) {
            javaType = "String";
        }
        return javaType;
    }

    @Override
    public String convertJavaTypeToSqlType(String javaType) {
        return null;
    }
}
