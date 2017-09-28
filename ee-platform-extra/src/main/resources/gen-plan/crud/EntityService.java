package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.service;

import com.ax.common.service.BaseService;

import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.dao.${table.className}Dao;
import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity.${table.className};

import org.springframework.stereotype.Service;

<#assign createDate = .now>

/**
 * Created by ${createUser!"AxCodeGen"} on ${createDate?string["yyyy/MM/dd"]}.
 */
@Service
public class ${table.className}Service extends BaseService<${table.className}, ${table.className}Dao> {


}