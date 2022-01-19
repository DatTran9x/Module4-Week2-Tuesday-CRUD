package main.repository;

import main.model.Branch;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends PagingAndSortingRepository<Branch,Integer> {
}
