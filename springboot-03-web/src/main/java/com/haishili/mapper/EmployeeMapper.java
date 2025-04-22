package com.haishili.mapper;

import com.haishili.pojo.Department;
import com.haishili.pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    @Select("SELECT * FROM tb_emp WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "email", column = "email"),
            @Result(property = "birthday", column = "birthday"),
            // 关联 Department 对象
            @Result(
                    property = "department",      // Employee 类中的属性名
                    column = "department",        // tb_emp 表中的外键列名
                    javaType = Department.class,
                    one = @One(select = "com.haishili.mapper.DepartmentMapper.findById")
            )
    })
    Employee findById(Integer id);
    @Select("SELECT * FROM tb_emp")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "lastname", column = "lastname"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "email", column = "email"),
            @Result(property = "birthday", column = "birthday"),
            @Result(
                    property = "department",
                    column = "department",  // tb_emp.department 是外键
                    javaType = Department.class,
                    one = @One(select = "com.haishili.mapper.DepartmentMapper.findById")
            )
    })
    List<Employee> findAll();

    @Insert("insert into tb_emp(id,lastname,email,gender,department,birthday) values (#{id},#{lastname},#{email},#{gender},#{department},#{birthday})")
    int addEmployee(Employee employee);

    @Update("")
    int updateEmployee(Employee employee);

    @Delete("delete * from tb_emp where id = #{id}")
    int deleteEmployeeById(Integer id);
}
