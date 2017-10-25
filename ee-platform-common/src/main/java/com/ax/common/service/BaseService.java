package com.ax.common.service;

import com.ax.common.repository.BaseDao;
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

    @Transactional
    public T save(T t) {
        return dao.save(t);
    }

    @Transactional
    public List<T> save(Iterable<T> t) {
        return dao.save(t);
    }

    @Transactional
    public void delete(T t) {
        dao.delete(t);
    }

    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    public T findOne(Long id) {
        return dao.findOne(id);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public List<T> findAll(List<Long> ids) {
        return dao.findAll(ids);
    }

    public List<T> findAll(Sort sort) {
        return dao.findAll(sort);
    }

    public Page<T> findAll(Pageable page) {
        return dao.findAll(page);
    }

    public List<T> findAll(Specification<T> specification) {
        return dao.findAll(specification);
    }

    public List<T> findAll(Specification<T> specification, Sort sort) {
        return dao.findAll(specification, sort);
    }

    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return dao.findAll(specification, pageable);
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
            sort = new Sort(Sort.Direction.DESC, "id");
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
