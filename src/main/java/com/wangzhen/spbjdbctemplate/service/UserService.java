package com.wangzhen.spbjdbctemplate.service;

/**
 * @ClassName UserService
 * @Description
 * @Author momo
 * @Date 2019/2/5 下午4:00
 **/
import java.util.List;

import javax.annotation.Resource;

import com.wangzhen.spbjdbctemplate.bean.User;
import com.wangzhen.spbjdbctemplate.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 注入UserRepository
    @Resource
    private UserRepository userRepository;

    public int insertUser(){
        return userRepository.insertUser();
    }

    public User selectByUsername(String username){
        return userRepository.selectByUsername(username);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User insertGetKey(User user) {
        return userRepository.insertGetKey(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
