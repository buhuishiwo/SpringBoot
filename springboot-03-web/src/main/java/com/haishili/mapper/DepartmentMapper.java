package com.haishili.mapper;

import com.haishili.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    List<Department> findAll();

    Department findById(Integer id);
    int addDept(Department department);
}
