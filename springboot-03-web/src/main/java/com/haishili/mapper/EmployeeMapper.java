package com.haishili.mapper;


import com.haishili.pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {


//    Employee findById(Integer id);

    List<Employee> findAll();

//    @Insert("insert into tb_emp(id,lastname,email,gender,department,birthday) values (#{id},#{lastname},#{email},#{gender},#{department},#{birthday})")
    int addEmployee(Employee employee);
//
//    @Update("")
    int updateEmployee(Employee employee);
//
//    @Delete("delete * from tb_emp where id = #{id}")
    int deleteEmployeeById(Integer id);
}
