package main.service;

import main.model.Employee;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    void delete(int id);
    Employee findById(int id);
    List<Employee> sort();
    List<Employee> reverse();
}
