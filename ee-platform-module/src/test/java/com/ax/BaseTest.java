package com.ax;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by kyy on 2017/10/25.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@SpringBootTest
@Rollback
public class BaseTest {

}
