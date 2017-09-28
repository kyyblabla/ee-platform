package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity;

import java.time.*;

<#assign createDate = .now>
/**
 * ${table.tableComment!""}
 * Table Name: ${table.tableName}
 * Created by ${createUser!"AxCodeGen"} on ${createDate?string["yyyy/MM/dd"]}.
 */
public class ${table.className} {

<#list table.columns as column>
    private ${column.attributeType} ${column.attributeName};
</#list>

    public ${table.className}() {}

<#list table.columns as column>
    public ${column.attributeType} get${column.attributeNameFlu}() {
        return this.${column.attributeName};
    }

    public void set${column.attributeNameFlu}(${column.attributeType} ${column.attributeName}) {
        this.${column.attributeName} = ${column.attributeName};
    }

</#list>

    public String toString() {
        return "${table.className}"+
<#list table.columns as column>
        "${column.attributeName}=" + ${column.attributeName} <#if column_has_next>+ ", " +<#else>+")";</#if>
</#list>
    }
}