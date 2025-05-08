package com.haishili.service;

import com.haishili.mapper.DepartmentMapper;
import com.haishili.mapper.EmployeeMapper;
import com.haishili.pojo.Department;
import com.haishili.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haishili
 * @date 2025/5/8
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    public void save(Employee employee) {
        Department department = departmentMapper.findById(employee.getDeptid());
        if(department == null && employee.getDeptName()!=null) {
            Department department1 = new Department(employee.getDeptid(), employee.getDeptName());
            departmentMapper.addDept(department1);
            employee.setDeptid(department1.getDeptid());
        }
        int i = employeeMapper.addEmployee(employee);
        if(i>0) {
            System.out.println("添加成功");
        }
    }
}
