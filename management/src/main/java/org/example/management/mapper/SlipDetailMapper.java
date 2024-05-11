package org.example.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.SlipDetail;

import java.util.List;

@Mapper
public interface SlipDetailMapper {
    //根据开单id获取
    public List<SlipDetail> list(Integer slipId,Integer goodId);
    //新增开单细节
    @Insert("insert into slip_detail ( slip_id, good_id, number) " +
            "values ( #{slipId}, #{goodId},#{number});")
    void insert(SlipDetail slipDetail);
    //修改开单细节信息
    void update(SlipDetail slipDetail);
    //根据id查询开单细节信息
    @Select("select id, slip_id, good_id, number " +
            "from slip_detail " +
            "where id = #{id}")
    SlipDetail findById(Integer id);
    //批量删除
    void delete(List<Integer> ids);
}
