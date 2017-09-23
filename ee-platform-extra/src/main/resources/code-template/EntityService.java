package ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.service;

import com.ax.common.service.BaseService;

import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.dao.${className}Dao;
import ${packageName}.${moduleName}<#if subModuleName != "">.${subModuleName}</#if>.entity.${className};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created <#if createUser != "">.${createUser}</#if> on ${createDate}.
 */
@Service
public class ${className}Service extends BaseService<${className}, ${className}Dao> {


}