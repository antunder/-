package org.example.management.service;

import org.example.management.pojo.PageBean;
import org.example.management.pojo.Good;

import java.util.List;

public interface GoodService {
    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     货品名称
     * @param state      货品状态
     * @param storeId  仓库id
     * @param decri    货品规格
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short state,Integer storeId,String decri);
    /**
     * 保存仓库信息
     * @param good
     */
    void save(Good good);
    /**
     * 更新员工
     * @param good
     */
    void update(Good good);
    /**
     * 根据ID查询仓库
     * @param id
     * @return
     */
    public Good getById(Integer id);
    /**
     * 查询所有的仓库数据
     * @return   存储good对象的集合
     */
    public List<Good> getAll();
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
}
