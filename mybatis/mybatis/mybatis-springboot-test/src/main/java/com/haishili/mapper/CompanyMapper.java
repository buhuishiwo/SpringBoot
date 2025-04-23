package com.haishili.mapper;

import com.haishili.pojo.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CompanyMapper {

    List<Company> selectAll();
}
