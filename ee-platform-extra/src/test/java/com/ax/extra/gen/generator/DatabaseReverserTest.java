package com.ax.extra.gen.generator;

import com.ax.extra.gen.model.GenTable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kyy on 2017/9/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseReverserTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Connection getConnection() throws SQLException {
        return jdbcTemplate.getDataSource().getConnection();
    }

    public DatabaseReverser getDatabaseReverser() throws SQLException {
        return DatabaseReverser.createDatabaseReverser(getConnection());
    }

    @Test
    public void getTableInfo() throws Exception {
        GenTable tableInfo = getDatabaseReverser().getTable("ee-platform", "user");
        Assert.assertNotNull(tableInfo);
    }

    @Test
    public void getTableNames() throws Exception {

        List<String> tableNames = getDatabaseReverser().getTableNames("ee-platform");
        Assert.assertTrue(tableNames.size() > 0);
    }

    @Test
    public void getTables() throws Exception {
        List<GenTable> tables = getDatabaseReverser().getTables("ee-platform");
        Assert.assertTrue(tables.size() > 0);
    }


}