package com.ax.extra.gen;

import com.ax.extra.gen.util.DatabaseUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kyy on 2017/10/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String[] tables = {
            "sys_menu",
            "sys_organization",
            "sys_role",
            "sys_role_menu",
            "sys_role_org",
            "sys_user_role",
            "sys_user",
    };

    @Test
    public void genCode() throws Exception {
        DatabaseUtil databaseUtil = DatabaseUtil.createDatabaseReverser(jdbcTemplate.getDataSource().getConnection());
        Generator generator = new Generator(databaseUtil, "ee-platform", "com.ax.test");
        byte[] bytes = generator.genCode(Arrays.asList(tables), "system", "user");
        FileUtils.writeByteArrayToFile(new File("/Users/kyy/data/test/demo.zip"), bytes);
    }

}