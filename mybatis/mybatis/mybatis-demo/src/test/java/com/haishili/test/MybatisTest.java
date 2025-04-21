package com.haishili.test;

import com.haishili.mapper.BrandMapper;
import com.haishili.mapper.UserMapper;
import com.haishili.pojo.Brand;
import com.haishili.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author haishili
 * @date 2025/4/18
 */
public class MybatisTest {
    @Test
    public void selectAll() throws IOException {
        int status = 1;
        String companyName = "小米";
        String brandName = "小米";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand1 = new Brand();
        brand1.setStatus(status);
        brand1.setCompanyName(companyName);
        brand1.setBrandName(brandName);
        //1. 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        for (Brand brand : brands) {
            System.out.println(brand);
        }
        Brand brand = brandMapper.selectById(1);
        System.out.println(brand);

        List<Brand> xiaomi = brandMapper.selectByCondition(brand1);
        System.out.println(xiaomi);
        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void selectByCondition() throws IOException {
        int status = 1;
        String companyName = "小米";
        String brandName = "小米";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand1 = new Brand();
//        brand1.setStatus(status);
//        brand1.setCompanyName(companyName);
//        brand1.setBrandName(brandName);

        //1. 加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> xiaomi = brandMapper.selectByCondition(brand1);
        System.out.println(xiaomi);
        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void add() throws IOException {
        int status = 1;
        String companyName = "Apple";
        String brandName = "Apple";
        int ordered = 100;
        String description = "赢";

        Brand brand1 = new Brand();
        brand1.setStatus(status);
        brand1.setCompanyName(companyName);
        brand1.setBrandName(brandName);
        brand1.setOrdered(ordered);
        brand1.setDescription(description);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.addBrand(brand1);
        sqlSession.commit();
        System.out.println(brand1.getId());

        brandMapper.selectAll().forEach(System.out::println);
    }
    @Test
    public void update() throws IOException {
        int id = 8;
        String companyName = "Google";
        String brandName = "Google";
        int ordered = 10;
        int status = 1;
        Brand brand = new Brand();
        brand.setId(id);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setOrdered(ordered);
        brand.setStatus(status);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 执行sql
        //List<Object> users = sqlSession.selectList("test.selectAll");
        //3.1 获取UserMapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.updateBrand(brand);

        sqlSession.commit();

    }
    @Test
    public void deleteById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteBrand(1);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteByIds() throws IOException {
        int[] ids = new int[] { 2, 3 };
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        sqlSession.commit();
    }
}

