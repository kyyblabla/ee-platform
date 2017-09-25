package com.ax.extra.gen.code;

import com.ax.common.util.Exceptions;
import com.ax.extra.gen.model.GenColumn;
import com.ax.extra.gen.model.GenTable;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据库反向
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

    /**
     * 获取表信息
     *
     * @param databaseName 库名
     * @param tableName    表明
     * @return
     */
    public GenTable getTable(String databaseName, String tableName) {
        try {
            // 获取基本表信息
            GenTable table = new GenTable();
            table.setTableName(tableName);
            table.setColumns(getColumns(databaseName, tableName));
            table.setClassName(convertLodashCaseToCamelCase(table.getTableName()));
            table.setClassNameFll(convertLodashCaseToFirstLetterLowerCaseCamelCase(table.getTableName()));

            ResultSet rs = conn.getMetaData().getTables(null, databaseName, tableName, new String[]{"TABLE"});
            //设置备注信息
            if (rs.next()) {
                table.setTableComment(rs.getString("REMARKS"));
            }
            return table;
        } catch (SQLException e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * 获取表列表
     *
     * @param databaseName
     * @return
     * @throws SQLException
     */
    public List<GenTable> getTables(String databaseName) throws SQLException {
        return getTableNames(databaseName).stream()
                .map(tableName -> getTable(databaseName, tableName))
                .collect(Collectors.toList());
    }

    /**
     * 获取数据库表名称
     *
     * @param databaseName
     * @return
     * @throws SQLException
     */
    public List<String> getTableNames(String databaseName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables(null, databaseName, "%", new String[]{"TABLE"});
        List<String> tables = Lists.newArrayList();
        while (rs.next()) {
            tables.add(rs.getString("TABLE_NAME"));
        }
        return tables;
    }

    /**
     * 获取列
     *
     * @param databaseName 库名
     * @param tableName    表名
     * @return
     * @throws SQLException
     */
    public List<GenColumn> getColumns(String databaseName, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getColumns(null, databaseName, tableName, "%");
        List<GenColumn> columns = Lists.newArrayList();
        while (rs.next()) {
            GenColumn column = new GenColumn();
            column.setNullable(StringUtils.equals("YES", rs.getString("IS_NULLABLE")));
            column.setAutoIncrement(StringUtils.equals("YES", rs.getString("IS_AUTOINCREMENT")));

            column.setColumnName(rs.getString("COLUMN_NAME"));
            column.setColumnType(rs.getString("TYPE_NAME"));
            column.setColumnComment(rs.getString("REMARKS"));

            column.setAttributeName(convertLodashCaseToFirstLetterLowerCaseCamelCase(column.getColumnName()));
            column.setAttributeNameFlu(convertLodashCaseToCamelCase(column.getColumnName()));
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


    /**
     * 获取主键列表
     *
     * @param databaseName 库名
     * @param tableName    表名
     * @return
     * @throws SQLException
     */
    private List<String> getPrimaryKey(String databaseName, String tableName) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getPrimaryKeys(null, databaseName, tableName);
        List<String> keys = Lists.newArrayList();
        while (rs.next()) {
            keys.add(rs.getString("COLUMN_NAME"));
        }
        return keys;
    }


    /**
     * sql数据类型转化为java数据类型
     * 其中由jdk8提供日期、时间类型，不使用java.utils提供的日期时间类型
     *
     * @param sqlType
     * @return
     */
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
