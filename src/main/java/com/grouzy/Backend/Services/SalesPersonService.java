package com.grouzy.Backend.Services;

import com.grouzy.Backend.Entities.SalesPerson;
import com.grouzy.Backend.Entities.User;
import com.grouzy.Backend.Repositories.SalesPersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesPersonService {

    private SalesPersonRepository repo;

    List<SalesPerson> SalesPerson = new ArrayList();

    public SalesPersonService(SalesPersonRepository repo) {
        this.repo = repo;
    }

    public List<SalesPerson> findAll() {
        return repo.findAll();
    }

    public Optional<SalesPerson> findById(long salesPersonId) {
        return repo.findById(salesPersonId);
    }
}
