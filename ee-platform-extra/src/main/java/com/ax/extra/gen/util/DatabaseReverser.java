package com.ax.extra.gen.util;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kyy on 2017/9/22.
 */
public class DatabaseReverser {

    private Connection conn;

    private DatabaseReverser(Connection conn) {
        this.conn = conn;
    }


    public static DatabaseReverser createDatabaseReverser(Connection conn) {
        return new DatabaseReverser(conn);
    }

    public Table getTable(String databaseName, String tableName) {
        try {
            // 获取基本表信息
            Table table = new Table();
            table.setTableName(tableName);
            table.setColumns(getColumns(databaseName, tableName));
            table.setClassMame(convertLodashCaseToCamelCase(table.getTableName()));
            table.setClassMameFll(convertLodashCaseToFirstLetterLowerCaseCamelCase(table.getTableName()));

            ResultSet rs = conn.getMetaData().getTables(null, databaseName, tableName, new String[]{"TABLE"});
            //设置备注信息
            if (rs.next()) {
                table.setTableComment(rs.getString("REMARKS"));
            }
            return table;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Table> getTables(String databaseName) throws SQLException {
        return getTableNames(databaseName).stream()
                .map(tableName -> getTable(databaseName, tableName))
                .collect(Collectors.toList());
    }
    
    public List<String> getTableNames(String databaseName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables(null, databaseName, "%", new String[]{"TABLE"});
        List<String> tables = Lists.newArrayList();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    public List<Column> getColumns(String databaseName, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getColumns(null, databaseName, tableName, "%");
        List<Column> columns = Lists.newArrayList();
        while (rs.next()) {
            Column column = new Column();
            column.setNullable(StringUtils.equals("YES", rs.getString("IS_NULLABLE")));
            column.setAutoIncrement(StringUtils.equals("YES", rs.getString("IS_AUTOINCREMENT")));

            column.setColumnName(rs.getString("COLUMN_NAME"));
            column.setColumnType(rs.getString("TYPE_NAME"));
            column.setColumnComment(rs.getString("REMARKS"));

            column.setAttributeName(convertLodashCaseToCamelCase(column.getColumnName()));
            column.setAttributeType(convertSqlTypeToJavaType(column.getColumnType()));

            columns.add(column);
        }

        //设定主键
        List<String> primaryKeys = getPrimaryKey(databaseName, tableName);
        columns.stream()
                .filter(column -> primaryKeys.contains(column.getColumnName()))
                .forEach(column -> {
                    column.setPrimaryKey(true);
                });
        return columns;
    }

    @Data
    public static class Table {

        private String tableName;
        private String tableComment;

        private String classMame;
        private String classMameFll; //fll：首字母小写 first litter lowercase

        private List<Column> columns;

    }

    @Data
    public static class Column {

        private boolean primaryKey;
        private boolean nullable;
        private boolean autoIncrement;

        private String columnName;
        private String columnType;
        private String columnComment;

        private String attributeName;
        private String attributeType;

    }


    private List<String> getPrimaryKey(String databaseName, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getPrimaryKeys(null, databaseName, tableName);
        List<String> keys = Lists.newArrayList();
        while (rs.next()) {
            keys.add(rs.getString("COLUMN_NAME"));
        }
        return keys;
    }


    private String convertSqlTypeToJavaType(String sqlType) {

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

    /**
     * 下换线命名转化为驼峰命名
     *
     * @param str
     * @return
     */
    private String convertLodashCaseToCamelCase(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return Arrays.stream(str.split("_"))
                .map(String::trim)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining());
    }

    /**
     * 下换线命名转换为首字母小写的驼峰命名
     *
     * @param str
     * @return
     */
    private String convertLodashCaseToFirstLetterLowerCaseCamelCase(String str) {
        String resultCamelCase = convertLodashCaseToCamelCase(str);
        return StringUtils.uncapitalize(resultCamelCase);
    }


}
