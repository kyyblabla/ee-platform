package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.controller;


import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity.${table.className};
import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.dao.${table.className}Dao;
import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.service.${table.className}Service;

import com.ax.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#assign createDate = .now>

/**
 * Created by ${createUser!"AxCodeGen"} on ${createDate?string["yyyy/MM/dd"]}.
 */
@RequestMapping("/${table.className}")
@RestController
public class ${table.className}Controller extends BaseController {

    @Autowired
    private ${table.className}Service ${table.classNameFll}Dao;

    @Autowired
    private ${table.className}Service ${table.classNameFll}Service;

}
