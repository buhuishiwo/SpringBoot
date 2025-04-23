package com.haishili.mapper;

import com.haishili.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author haishili
 * @date 2025/4/23
 */
@Mapper
@Repository
public interface BrandMapper {
    List<Brand> findAll();
}
