package cn.com.spring.springbootdemo.hello;

import cn.com.spring.springbootdemo.dao.DepartmentDao;
import cn.com.spring.springbootdemo.dao.EmployeeDao;
import cn.com.spring.springbootdemo.entities.Department;
import cn.com.spring.springbootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee ee = employeeDao.get(id);
        model.addAttribute("emp",ee);

        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }
}
