//package com.haishili.dao;
//
//import com.haishili.pojo.Department;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author haishili
// * @date 2025/4/15
// */
//@Repository
////部门dao
//public class DepartmentDao {
//    //模拟数据库
//    private static Map<Integer, Department> departments = null;
//    //在类的创建时执行一次
//    static {
//        departments = new HashMap<>();
//        departments.put(101,new Department(101,"教学部"));
//        departments.put(102,new Department(102,"市场部"));
//        departments.put(103,new Department(103,"运营部"));
//        departments.put(104,new Department(104,"售后部"));
//        departments.put(105,new Department(105,"物流部"));
//    }
//
//    //获得所有部门信息
//    public static Collection<Department> getDepartments() {
//        return departments.values();
//    }
//
//    //通过id查找部门
//    public static Department getDepartment(Integer id) {
//        return departments.get(id);
//    }
//}
