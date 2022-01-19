package main.service;

import main.model.Employee;
import main.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

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
        return employeeRepo.findAllSortByAgeASC();
    }

    @Override
    public List<Employee> reverse(){
       return employeeRepo.findAllSortByAgeDESC();
    }
}
