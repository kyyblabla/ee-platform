package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity;

import java.time.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
<#assign createDate = .now>

/**
 * ${table.tableComment!""}
 * Created by ${createUser!"AxCodeGen"} on ${createDate?string["yyyy/MM/dd"]}.
 */
@Entity
@Table(name="${table.tableName}")
public class ${table.className} {

<#list table.columns as column>
    <#if column.primaryKey>
    @Id
    </#if>
    <#if column.autoIncrement>
    @GeneratedValue
    </#if>
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

    @Override
    public String toString() {
        return "${table.className} ("+
<#list table.columns as column>
                "${column.attributeName}=" + ${column.attributeName} <#if column_has_next>+ ", " +<#else>+")";</#if>
</#list>
    }
}