package com.haishili;

import com.haishili.mapper.BrandMapper;
import com.haishili.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class MybatisSpringbootTestApplicationTests {
    @Autowired
    BrandMapper brandMapper;
    @Test
    void contextLoads() {

         List<Brand> brands = brandMapper.findAll();
         for (Brand brand : brands) {
             System.out.println(brand);
         }
    }

}
