package me.hynd.service;

import me.hynd.mapper.BaseMapper;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by H on 2015/4/25.
 */
public abstract class BaseServiceAdapter<T> implements BaseMapper<T> {

    public void save(T t) {

    }

    public void insert(T t) {

    }

    public int update(T t) {
        return 0;
    }

    public void deleteById(Serializable id) {

    }

    public void deleteByIds(Serializable[] ids) {

    }

    public List<T> findAll() {
        return null;
    }

    public T findById(Serializable id) {
        return null;
    }

    public List<T> findByEntity(T t) {
        return null;
    }

    public List<T> findByEntityForPage(T t, RowBounds rowBounds) {
        return null;
    }

    public List<T> findByMap(Map<String, Object> map) {
        return null;
    }

    public List<T> findByMapForPage(Map<String, Object> map, RowBounds rowBounds) {
        return null;
    }

}
