package com.ax.system.user.dao;

import com.ax.BaseTest;
import com.ax.system.user.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by kyy on 2017/10/25.
 */
public class RoleDaoTest extends BaseTest {

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testFindOne() {
        Role one = roleDao.findOne(1l);
        assertNotNull(one);
    }

}