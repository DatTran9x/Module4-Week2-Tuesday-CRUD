package main.controller;

import main.model.Branch;
import main.model.Employee;
import main.service.IBranchService;
import main.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    IBranchService branchService;

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/home")
    public ModelAndView home(){
        List<Employee> list = employeeService.findAll();
        ModelAndView mav = new ModelAndView("/homepage");
        mav.addObject("list",list);
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView addForm(){
        ModelAndView mav = new ModelAndView("/create");
        Employee employee = new Employee();
        List<Branch> list = branchService.findAll();
        mav.addObject("employee",employee);
        mav.addObject("branch",list);
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView add(@ModelAttribute Employee employee, @RequestParam int branchId){
        Branch branch = new Branch();
        branch.setId(branchId);
        employee.setBranch(branch);
        employeeService.save(employee);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/edit");
        Employee employee = employeeService.findById(id);
        List<Branch> list = branchService.findAll();
        mav.addObject("employee",employee);
        mav.addObject("branch",list);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/delete");
        Employee employee = employeeService.findById(id);
        mav.addObject("employee",employee);
        return mav;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        employeeService.delete(id);
        return new ModelAndView("redirect:/home");
    }
    
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        ModelAndView mav = new ModelAndView("/detail");
        mav.addObject("employee",employee);
        return mav;
    }

    @PostMapping("/sort")
    public ModelAndView sort() {
        List<Employee> list = employeeService.sort();
        ModelAndView mav = new ModelAndView("/homepage");
        mav.addObject("list",list);
        return mav;
    }

    @PostMapping("/reverse")
    public ModelAndView reverse(){
        List<Employee> list = employeeService.reverse();
        ModelAndView mav = new ModelAndView("/homepage");
        mav.addObject("list",list);
        return mav;
    }
}
