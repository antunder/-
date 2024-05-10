package org.example.management.service;

import org.example.management.pojo.User;
import org.example.management.pojo.PageBean;

import java.util.List;

public interface UserService {
    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     用户名称
     * @param kind      用户类别
     * @param gender    用户性别
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short kind, Short gender);
    /**
     * 保存用户信息
     * @param user
     */
    void save(User user);
    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);
    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public User getById(Integer id);
    /**
     * 查询所有的用户数据
     * @return   存储User对象的集合
     */
    public List<User> getAll();
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
}
