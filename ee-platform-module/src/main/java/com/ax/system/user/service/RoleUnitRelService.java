package com.ax.system.user.service;

import com.ax.common.service.BaseService;

import com.ax.system.user.dao.RoleDao;
import com.ax.system.user.dao.RoleUnitRelDao;
import com.ax.system.user.entity.Role;
import com.ax.system.user.entity.RoleUnitRel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by AxCodeGen on 2017/10/25.
 */
@Service
public class RoleUnitRelService extends BaseService<RoleUnitRel, RoleUnitRelDao> {


    public List<RoleUnitRel> getRoleRelByUserId(Long userId) {
        return dao.findByUnitIdAndUnitType(userId, "user");
    }

    public List<RoleUnitRel> getRoleRelByOrgId(Long orgId) {
        return dao.findByUnitIdAndUnitType(orgId, "org");
    }

}