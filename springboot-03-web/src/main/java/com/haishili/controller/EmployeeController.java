package com.haishili.controller;


import com.haishili.mapper.DepartmentMapper;
import com.haishili.mapper.EmployeeMapper;
import com.haishili.pojo.Employee;
import com.haishili.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author haishili
 * @date 2025/4/16
 */
@Controller
@Tag(
        name = "员工管理",
        description = "员工管理接口"
)
public class EmployeeController {

    @Schema(description = "员工数据操作Mapper")
    @Autowired
    EmployeeMapper employeeMapper;
    @Schema(description = "部门数据操作Mapper")
    @Autowired
    DepartmentMapper departmentMapper;
    @Schema(description = "员工操作方法")
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String empList(Model model) {
//        Collection<Employee> employees = employeeDao.getEmployees();
//        model.addAttribute("employees", employees);
//        return "emp/list";
        List<Employee> allEmployee = employeeMapper.findAll();
        model.addAttribute("employees", allEmployee);
        return "emp/list";
    }
    @Operation(description = "跳转到添加员工页面")
    @GetMapping("/emp")
    public String toAdd(Model model) {
        model.addAttribute("departments",departmentMapper.findAll());
        return "emp/add";
    }
    @Operation(description = "添加员工")
    @PostMapping("/emp")
    public String addEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/emps";
    }

//    @GetMapping("/emp")
//    public String toAdd(Model model) {
//        model.addAttribute("departments", DepartmentDao.getDepartments());
//        return "emp/add";
//    }
//    @PostMapping("/emp")
//    public String addEmployee(Employee employee) {
//        //添加员工业务代码
//        employeeDao.save(employee);
//        System.out.println("save=>"+employee);
//        return "redirect:/emps";
//    }
//    @GetMapping("/emp/{id}")
//    public String toUpdate(@PathVariable("id") int id, Model model) {
//        model.addAttribute("emp", employeeDao.getEmployee(id));
//        model.addAttribute("depts",DepartmentDao.getDepartments());
//        return "emp/edit";
//    }
//    @PostMapping("/updateEmp")
//    public String updateEmployee(Employee employee) {
//        employeeDao.save(employee);
//        System.out.println("update=>"+employee);
//        return "redirect:/emps";
//    }
//    @GetMapping("/emp/delete/{id}")
//    public String deleteEmployee(@PathVariable("id") int id) {
//        employeeDao.delete(id);
//        return "redirect:/emps";
//    }
}
