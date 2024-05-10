package org.example.management.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.example.management.mapper.UserMapper;
import org.example.management.pojo.User;
import org.example.management.pojo.PageBean;
import org.example.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short kind, Short gender) {
        PageHelper.startPage(page,pageSize);
        List<User> userList = userMapper.list(name, kind,gender);
        Page<User> p = (Page<User>) userList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void save(User user) {
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.delete(ids);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userMapper.findById(id);
    }
}
