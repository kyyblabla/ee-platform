package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity.${table.className};

<#assign createDate = .now>
/**
 * Created by ${createUser!"AxCodeGen"} on ${createDate?string["yyyy/MM/dd"]}.
 */
@JpaDao
public interface ${table.className}Dao extends BaseDao<${table.className}> {

}