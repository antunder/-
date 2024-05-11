package org.example.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.Cust;

import java.util.List;

@Mapper
public interface CustMapper {
    //客户信息查询
    public List<Cust> list(String name, Short kind,Short gender);
    //新增客户
    @Insert("insert into cust ( name,address, kind, gender,phone,create_time) " +
            "values ( #{name},#{address}, #{kind},#{gender},#{createTime});")
    void insert(Cust cust);
    //修改客户信息
    void update(Cust cust);
    //根据id查询客户信息
    @Select("select id, name,address, kind, gender,phone,phone,create_time " +
            "from cust " +
            "where id = #{id}")
    Cust findById(Integer id);
    //获取所有客户
    @Select("select id, name,address, kind, gender,phone,create_time from cust ")
    List<Cust> getAll();
    //批量删除
    void delete(List<Integer> ids);
}
