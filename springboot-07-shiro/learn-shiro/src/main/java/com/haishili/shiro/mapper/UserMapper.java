package com.haishili.shiro.mapper;

import com.haishili.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haishili
 */
@Repository
@Mapper
public interface UserMapper {

    List<User> findAll();

    User findByName(String name);
}
