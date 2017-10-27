package com.ax.common.service;

import com.ax.common.repository.BaseDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by kyy on 2017/9/10.
 */
public abstract class BaseService<T, D extends BaseDao<T>> {

    @Autowired
    protected D dao;

    public Page<T> findAll(int pageNum, int pageSize) {
        return findAll(pageNum, pageSize, null);
    }

    public Page<T> findAll(int pageNum, int pageSize, Sort sort) {
        return dao.findAll(buildPageRequest(pageNum, pageSize, sort));
    }

    /**
     * 创建分页请求
     *
     * @param pageNumber 当前页码
     * @param pageSize
     * @return
     */
    protected PageRequest buildPageRequest(int pageNumber, int pageSize, Sort sort) {
        if (sort == null) {
            sort = new Sort(Sort.Direction.ASC, "id");
        }
        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    /**
     * 创建动态组合查询条件
     * <p>
     * EQ 等于
     * LIKE 模糊
     * GT 大于
     * LT 小于
     * GTE 大于等于
     * LTE 小于等于
     * NEQ不等于
     * IN在()
     *
     * @param searchParams 表达式_[对象.]字段 如：EQ_user.age
     * @return
     */
    protected Specification<T> buildSpecification(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        Specification<T> spec = DynamicSpecifications.bySearchFilter(filters.values());
        return spec;
    }


}
