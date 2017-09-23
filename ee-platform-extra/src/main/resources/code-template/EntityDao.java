package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.dao

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity.${className};


/**
 * Created <#if createUser != "">.${createUser}</#if> on ${createDate}.
 */
@JpaDao
public interface ${className}Dao extends BaseDao<${className}> {

}