package org.example.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.Good;

import java.util.List;

@Mapper
public interface GoodMapper {
    //货品信息查询
    public List<Good> list(String name, Short state,Integer storeId,String decri);
    //新增货品
    @Insert("insert into good ( name, state, decri,store_id,jh_pri,pf_pri,ls_pri,storage,create_time) " +
            "values ( #{name}, #{state},#{decri},#{storeId},#{jhPri},#{pfPri},#{lsPri},#{storage},#{createTime});")
    void insert(Good good);
    //修改货品信息
    void update(Good good);
    //根据id查询货品信息
    @Select("select id, name, state, decri,store_id,jh_pri,pf_pri,ls_pri,storage,create_time " +
            "from good " +
            "where id = #{id}")
    Good findById(Integer id);
    //获取所有商品
    @Select("select id, name, state, decri,store_id,jh_pri,pf_pri,ls_pri,storage,create_time from good ")
    List<Good> getAll();
    //批量删除
    void delete(List<Integer> ids);
}
