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

import static org.junit.Assert.*;

/**
 * Created by kyy on 2017/10/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void genCode() throws Exception {

        Generator generator = new Generator(DatabaseUtil.createDatabaseReverser(jdbcTemplate.getDataSource().getConnection()));

        byte[] bytes = generator.genCode("ee-platform", "user", "com.ax.test", "system", "user");

        FileUtils.writeByteArrayToFile(new File("/Users/kyy/data/test/demo.zip"), bytes);

    }

}