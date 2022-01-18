package main.service;

import main.model.Employee;
import main.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepo.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> sort(){
        List<Employee> list = findAll();
        list.sort(Comparator.comparing(Employee::getAge));
        return list;
    }

    @Override
    public List<Employee> reverse(){
        List<Employee> list = findAll();
        list.sort(Comparator.comparing(Employee::getAge));
        Collections.reverse(list);
        return list;
    }
}
