package org.example.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.management.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    //用户信息查询
    public List<User> list(String name, Short kind,Short gender);
    //新增用户
    @Insert("insert into user ( username,name, kind, gender,create_time) " +
            "values ( #{name}, #{kind},#{createTime});")
    void insert(User user);
    //修改用户信息
    void update(User user);
    //根据id查询用户信息
    @Select("select id,username,password, name, kind, gender,create_time " +
            "from user " +
            "where id = #{id}")
    User findById(Integer id);
    //获取所有用户
    @Select("select id,username,password, name, kind, gender,create_time from user ")
    List<User> getAll();
    //批量删除
    void delete(List<Integer> ids);
}
