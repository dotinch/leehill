package me.hynd.mapper;

import me.hynd.annotation.DSMySQL;
import me.hynd.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by H on 2015/4/25.
 */
@DSMySQL
@Repository("userMapper")
public interface UserMapper {

    @CacheEvict(value = "sampleCache1", allEntries=true)
    int insert(User user);

    @Cacheable(value="sampleCache1")
    List<User> findAll();
}
