package com.ax.codegen.config;

import com.ax.extra.gen.util.DatabaseUtil;
import com.ax.extra.gen.Generator;
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
    public DatabaseUtil databaseReverser(JdbcTemplate jdbcTemplate) throws SQLException {
        return DatabaseUtil.createDatabaseReverser(jdbcTemplate.getDataSource().getConnection());
    }

    @Bean
    public Generator genService(DatabaseUtil databaseUtil) throws SQLException {
        return new Generator(databaseUtil);
    }

}
