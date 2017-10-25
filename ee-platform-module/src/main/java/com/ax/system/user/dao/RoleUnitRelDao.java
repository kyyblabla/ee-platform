package com.ax.system.user.dao;

import com.ax.common.annotation.JpaDao;
import com.ax.common.repository.BaseDao;

import com.ax.system.user.entity.RoleUnitRel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by AxCodeGen on 2017/10/25.
 */
@JpaDao
public interface RoleUnitRelDao extends BaseDao<RoleUnitRel> {

    List<RoleUnitRel> findByUnitIdAndUnitType(Long unitId, String unitType);

}