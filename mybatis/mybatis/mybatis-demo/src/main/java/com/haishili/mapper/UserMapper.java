package com.haishili.mapper;

import com.haishili.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author haishili
 * @date 2025/4/18
 */
public interface UserMapper {
    @Select("select * from tb_user")
    List<User> selectAll();
    User selectById(int id);
}
