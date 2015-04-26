package me.hynd.service.impl;

import me.hynd.mapper.UserMapper;
import me.hynd.model.User;
import me.hynd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by H on 2015/4/25.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name="userMapper")
    private UserMapper userMapper;


    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }


    @Override
    public List<User> findAll() {
        return this.userMapper.findAll();
    }
}
