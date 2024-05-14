package org.example.management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.BillDetail;

import java.util.List;

@Mapper
public interface BillDetailMapper {
    //根据开单id获取
    List<BillDetail> list(Integer slipId);
    //新增开单细节
    void insert(List<BillDetail> billDetails);
    //修改开单细节信息
    void update(List<BillDetail> billDetails);
    //根据id查询开单细节信息
    @Select("select * " +
            "from bill_detail " +
            "where id = #{id}")
    BillDetail findById(Integer id);
    //批量删除
    void delete(List<Integer> ids);
}
