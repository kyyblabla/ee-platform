package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.controller;


import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity.${className};
import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.dao.${className}Dao;
import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.service.${className}Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<#assign createDate = .now>

/**
 * Created by ${createUser!"AxCodeGen"} on ${createDate?string["yyyy/MM/dd"]}.
 */
@RestController
public class ${className}Controller extends BaseController {

    @Autowired
    private ${className}Service ${classNameFll}Dao;

    @Autowired
    private ${className}Service ${classNameFll}Service;

}
