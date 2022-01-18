package main.repository;

import main.model.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends CrudRepository<Branch,Integer> {
}