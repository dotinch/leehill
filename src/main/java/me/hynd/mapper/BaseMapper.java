package me.hynd.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;

public interface BaseMapper<T> {

     void save(T t);

     void insert(T t);

     int update(T t);

     void deleteById(Serializable id);

     void deleteByIds(Serializable[] ids);

     List<T> findAll();

     T findById(Serializable id);

     List<T> findByEntity(T t);

     List<T> findByEntityForPage(T t, RowBounds rowBounds);

     List<T> findByMap(Map<String, Object> map);

     List<T> findByMapForPage(Map<String, Object> map, RowBounds rowBounds);

}
