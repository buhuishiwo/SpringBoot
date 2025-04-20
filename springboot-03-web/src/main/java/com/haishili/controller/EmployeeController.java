package com.haishili.controller;

import com.haishili.dao.DepartmentDao;
import com.haishili.dao.EmployeeDao;
import com.haishili.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author haishili
 * @date 2025/4/16
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String empList(Model model) {
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAdd(Model model) {
        model.addAttribute("departments", DepartmentDao.getDepartments());
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        //添加员工业务代码
        employeeDao.save(employee);
        System.out.println("save=>"+employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("emp", employeeDao.getEmployee(id));
        model.addAttribute("depts",DepartmentDao.getDepartments());
        return "emp/edit";
    }
    @PostMapping("/updateEmp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        System.out.println("update=>"+employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
