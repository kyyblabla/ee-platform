package com.ax.extra.gen.convert;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by kyy on 2017/9/25.
 */
public class DefaultTypeConvert implements TypeConvert {


    private final static Configuration configuration;

    static {
        try {
            configuration = new PropertiesConfiguration("generator-type-convert.properties");
        } catch (ConfigurationException e) {
            throw new RuntimeException("获取配置文件失败，", e);
        }
    }

    @Override
    public String convertSqlTypeToJavaType(String sqlType) {
        String javaType = null;
        if (StringUtils.isNotBlank(sqlType)) {
            javaType = configuration.getString(sqlType.toLowerCase());
        }
        return StringUtils.isBlank(javaType) ? "Object" : javaType;
    }

    @Override
    public String convertJavaTypeToSqlType(String javaType) {
        return null;
    }
}
