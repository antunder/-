package org.example.management.service;

import org.example.management.pojo.PageBean;
import org.example.management.pojo.Store;

import java.time.LocalDate;
import java.util.List;

public interface StoreService {
    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     仓库名称
     * @param kind      仓库类别
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short kind);
    /**
     * 保存仓库信息
     * @param store
     */
    void save(Store store);
    /**
     * 更新员工
     * @param store
     */
    void update(Store store);
    /**
     * 根据ID查询仓库
     * @param id
     * @return
     */
    public Store getById(Integer id);
    /**
     * 查询所有的仓库数据
     * @return   存储store对象的集合
     */
    public List<Store> getAll();
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
}
