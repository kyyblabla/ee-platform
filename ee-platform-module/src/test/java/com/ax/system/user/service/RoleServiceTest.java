package com.ax.system.user.service;

import com.ax.BaseTest;
import com.ax.system.user.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kyy on 2017/10/25.
 */
public class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void getUserRoles() throws Exception {
        List<Role> userRoles = roleService.getUserRoles(1);
        assertTrue(!userRoles.isEmpty());
    }

}