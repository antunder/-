package org.example.management.service;

import org.example.management.pojo.BillDetail;

import java.util.List;

public interface BillDetailService {
    /**
     * 条件查询
     * @param slipId     开单id
     * @return
     */
    List<BillDetail> list(Integer slipId);
    /**
     * 保存开单细节信息
     * @param billDetails
     */
    void save(List<BillDetail> billDetails);
    /**
     * 更新开单细节
     * @param slipId
     * @param billDetails
     */
    void update(Integer slipId,List<BillDetail> billDetails);
    /**
     * 根据ID查询开单细节
     * @param id
     * @return
     */
    BillDetail getById(Integer id);
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
    /**
     * 审核通过对货品进行操作
     * @param slipId
     */
    void pass(Integer slipId);
}
