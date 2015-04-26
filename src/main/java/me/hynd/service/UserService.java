package me.hynd.service;

import me.hynd.model.User;

import java.util.List;

/**
 * Created by H on 2015/4/25.
 */
public interface UserService {

    int insert(User user);

    List<User> findAll();
}