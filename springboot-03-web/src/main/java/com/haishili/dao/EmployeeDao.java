//package com.haishili.dao;
//
//import com.haishili.pojo.Employee;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author haishili
// * @date 2025/4/15
// */
//@Repository
//public class EmployeeDao {
//    public static Map<Integer, Employee> employees = null;
//
//    static {
//        employees = new HashMap<>();
//        employees.put(1001,new Employee(1001,"jack","11111@gmail.com",1,DepartmentDao.getDepartment(101),new Date()));
//        employees.put(1002,new Employee(1002,"army","12111@gmail.com",0,DepartmentDao.getDepartment(102),new Date()));
//        employees.put(1003,new Employee(1003,"jacky","13111@gmail.com",1,DepartmentDao.getDepartment(103),new Date()));
//        employees.put(1004,new Employee(1004,"lucy","14111@gmail.com",0,DepartmentDao.getDepartment(104),new Date()));
//        employees.put(1005,new Employee(1005,"lessy","15111@gmail.com",1,DepartmentDao.getDepartment(105),new Date()));
//    }
//
//    private static Integer initId = 1006;
//
//    public void save(Employee employee) {
//        if(employee.getId() == null) {
//            employee.setId(initId++);
//        }
//        employee.setDepartment(DepartmentDao.getDepartment(employee.getDepartment().getId()));
//        //map当传入的key值相同时，相当于修改数据，不会添加数据
//        employees.put(employee.getId(), employee);
//    }
//    public  Collection<Employee> getEmployees() {
//        return employees.values();
//    }
//
//    public  Employee getEmployee(Integer id) {
//        return employees.get(id);
//    }
//
//    public  void delete(Integer id) {
//        employees.remove(id);
//    }
//
//}
//
