package com.haishili.shiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.haishili.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haishili
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
    User findByName(String name);
}
