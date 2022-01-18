package main.service;

import main.model.Branch;
import main.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService{
    @Autowired
    BranchRepo branchRepo;

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }
}
