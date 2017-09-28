package com.ax.codegen.config;

import com.ax.extra.gen.code.CodeGenerator;
import com.ax.extra.gen.code.DatabaseReverser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created by kyy on 2017/9/28.
 */
@Configuration
public class CodegenConfig {

    @Bean
    public DatabaseReverser databaseReverser(JdbcTemplate jdbcTemplate) throws SQLException {
        return DatabaseReverser.createDatabaseReverser(jdbcTemplate.getDataSource().getConnection());
    }


    @Bean
    public CodeGenerator codeGenerator() throws SQLException {


        CodeGenerator codeGenerator = new CodeGenerator("/Users/kyy/anxin_work/workspace/ee-platform/code/ee-platform/ee-platform-module");
        return codeGenerator;

    }



}
