package org.example.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.Store;

import java.util.List;

@Mapper
public interface StoreMapper {
    //仓库信息查询
    public List<Store> list(String name, Short kind);
    //新增仓库
    @Insert("insert into store ( name, kind, create_time) " +
            "values ( #{name}, #{kind},#{createTime});")
    void insert(Store store);
    //修改仓库信息
    void update(Store store);
    //根据id查询仓库信息
    @Select("select id, name, kind, create_time " +
            "from store " +
            "where id = #{id}")
    Store findById(Integer id);
    //获取所有仓库
    @Select("select id, name, kind, create_time from store ")
    List<Store> getAll();
    //批量删除
    void delete(List<Integer> ids);
}
