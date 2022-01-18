package main.service;

import main.model.Branch;

import java.util.List;

public interface IBranchService {
    List<Branch> findAll();
}
