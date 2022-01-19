package main.repository;

import main.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {

    @Query(value = "select e from Employee e order by e.age asc")
    List<Employee> findAllSortByAgeASC();

    @Query(value = "select e from Employee e order by e.age desc")
    List<Employee> findAllSortByAgeDESC();
}
