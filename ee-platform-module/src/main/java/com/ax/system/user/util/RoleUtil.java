package com.ax.system.user.util;

import com.ax.system.user.constant.UserConstant;
import com.ax.system.user.entity.Role;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by kyy on 2017/10/26.
 */
public class RoleUtil {

    public static boolean isAdmin(Role role) {
        return Objects.nonNull(role) && StringUtils.equals(role.getName(), UserConstant.ROLE_NAME_ADMIN);
    }

    public static boolean isAdmin(List<Role> roles) {
        return roles.stream().anyMatch(RoleUtil::isAdmin);
    }
}
