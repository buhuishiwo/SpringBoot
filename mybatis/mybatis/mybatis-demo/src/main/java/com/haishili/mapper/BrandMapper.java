<<<<<<< HEAD
package com.haishili.mapper;

import com.haishili.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author haishili
 * @date 2025/4/18
 */
public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);


//    List<Brand> selectByCondition(@Param("status") int status, @Param("brandName") String brandName, @Param("companyName") String companyName);

    List<Brand> selectByCondition(Brand brand);
//    List<Brand> selectByCondition(Map map);
    //添加
    void addBrand(Brand brand);
    //修改
    void updateBrand(Brand brand);
    //删除
    void deleteBrand(int id);
    //批量删除

    //@Param()可以指定传入数组的名称
    void deleteByIds(@Param("ids") int[] ids);
}
=======
package com.haishili.mapper;

import com.haishili.pojo.Brand;

import java.util.List;

/**
 * @author haishili
 * @date 2025/4/18
 */
public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
}
>>>>>>> f5e938b10231c61942ec365ae10582347c038c9b
