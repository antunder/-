package org.example.management.service;

import org.example.management.pojo.PageBean;
import org.example.management.pojo.Slip;
import org.example.management.pojo.SlipDetail;

import java.util.List;

public interface SlipDetailService {
    /**
     * 条件查询
     * @param slipId     开单id
     * @param goodId      货品id
     * @return
     */
    List<SlipDetail> list(Integer slipId, Integer goodId);
    /**
     * 保存开单细节信息
     * @param slipDetails
     */
    void save(List<SlipDetail> slipDetails);
    /**
     * 更新开单细节
     * @param slipId
     * @param slipDetails
     */
    void update(Integer slipId,List<SlipDetail> slipDetails);
    /**
     * 根据ID查询开单细节
     * @param id
     * @return
     */
    SlipDetail getById(Integer id);
    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);
    /**
     * 批量删除操作
     * @param slipId 开单id
     */
    void reject(Integer slipId);
}
