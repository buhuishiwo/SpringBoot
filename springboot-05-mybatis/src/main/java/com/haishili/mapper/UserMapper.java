package com.haishili.mapper;

import com.haishili.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haishili
 * @date 2025/4/22
 */
@Mapper
@Repository
public interface UserMapper {
    //@Select("select * from tb_user;")
    List<User> findAll();

    //@Select("select * from tb_user where id = #{id};")
    User findById(@Param("id") Integer id);

    int addUser(User user);
    int updateUser(User user);
    int deleteUser(@Param("id") Integer id);

}
