package com.haishili.mapper;

import com.haishili.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    @Select("select * from tb_dept;")
    List<Department> findAll();
    @Select("select * from tb_dept where id = #{id};")
    Department findById(Integer id);
}
