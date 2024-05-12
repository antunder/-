package org.example.management.service;

import org.example.management.pojo.PageBean;
import org.example.management.pojo.Cust;

import java.util.List;

public interface CustService {
    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     客户名称
     * @param kind      客户类别
     * @param gender    客户性别
     * @return
     */
    PageBean pageCust(Integer page, Integer pageSize, String name, Short kind,Short gender);
    /**
     * 条件分页查询供货商
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     客户名称
     * @param gender    客户性别
     * @return
     */
    PageBean pageSup(Integer page, Integer pageSize, String name,Short gender);
    /**
     * 保存客户信息
     * @param cust
     */
    void save(Cust cust);
    /**
     * 更新客户信息
     * @param cust
     */
    void update(Cust cust);
    /**
     * 根据ID查询客户
     * @param id
     * @return
     */
    public Cust getById(Integer id);
    /**
     * 查询所有的客户数据
     * @return   存储Cust对象的集合
     */
    public List<Cust> getAll();
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
}
