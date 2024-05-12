package org.example.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.Slip;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface SlipMapper {
    //查询
    List<Slip> list(Short kind, Short state, Integer storeId,Integer custId,LocalDate begin, LocalDate end);
    //新增开单
    void insert(Slip slip);
    //修改开单信息
    void update(Slip slip);
    //根据id查询开单信息
    @Select("select id, kind, state, store_id,cust_id,create_time " +
            "from slip " +
            "where id = #{id}")
    Slip findById(Integer id);
    //获取所有商品
    @Select("select id, kind, state, store_id,cust_id,create_time from slip ")
    List<Slip> getAll();
    //批量删除
    void delete(List<Integer> ids);
}
