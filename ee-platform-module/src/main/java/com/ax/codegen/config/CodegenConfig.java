package com.ax.codegen.config;

import com.ax.extra.gen.generator.DatabaseReverser;
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

}
