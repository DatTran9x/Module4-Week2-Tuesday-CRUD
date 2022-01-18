package main.service;

import main.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    void delete(int id);
    Employee findById(int id);
    List<Employee> sort();
    List<Employee> reverse();
}
