package org.example.management.service;

import org.example.management.pojo.PageBean;
import org.example.management.pojo.Slip;

import java.time.LocalDate;
import java.util.List;

public interface SlipService {
    /**
     * 条件分页查询销售单
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param kind      开单类别
     * @param state      开单状态
     * @param storeId    仓库id
     * @param custId     客户id
     * @param begin       开始时间
     * @param end          结束时间
     * @return
     */
    PageBean pageSale(Integer page, Integer pageSize, Short kind, Short state, Integer storeId, Integer custId, LocalDate begin,LocalDate end);
    /**
     * 条件分页查询采购单
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param state      开单状态
     * @param storeId    仓库id
     * @param custId     客户id
     * @param begin       开始时间
     * @param end          结束时间
     * @return
     */
    PageBean pageBuy(Integer page, Integer pageSize, Short state, Integer storeId, Integer custId, LocalDate begin,LocalDate end);
    /**
     * 保存开单信息
     *
     * @param slip
     * @return
     */
    Integer save(Slip slip);
    /**
     * 更新开单信息
     * @param slip
     */
    void update(Slip slip);
    /**
     * 根据ID查询开单
     * @param id
     * @return
     */
    public Slip getById(Integer id);
    /**
     * 查询所有的开单数据
     * @return   存储Slip对象的集合
     */
    public List<Slip> getAll();
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
    /**
     * 查询
     * @param kind      开单类别
     * @param state      开单状态
     * @param storeId    仓库id
     * @param custId     客户id
     * @param begin       开始时间
     * @param end          结束时间
     * @return
     */
    List<Slip> list(Short kind, Short state, Integer storeId, Integer custId, LocalDate begin,LocalDate end);
}
