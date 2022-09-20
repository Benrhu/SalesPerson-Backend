package com.grouzy.Backend.Controllers;

import com.grouzy.Backend.Entities.SalesPerson;
import com.grouzy.Backend.Entities.User;
import com.grouzy.Backend.Repositories.SalesPersonRepository;
import com.grouzy.Backend.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SalesPersonController {

    private SalesPersonRepository salesPersonRepository;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public SalesPersonController(SalesPersonRepository salesPersonRepository){
        this.salesPersonRepository = salesPersonRepository;
    }

    @GetMapping("/api/users")
    public List<SalesPerson> findAll() {
        return salesPersonRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<SalesPerson> findOneById(@PathVariable Long salesPersonId) {
        Optional<SalesPerson> salesPersonOpt = salesPersonRepository.findById(salesPersonId);
        if (salesPersonOpt.isPresent())
            return ResponseEntity.ok(salesPersonOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("api/salesPerson")
    public ResponseEntity<SalesPerson> create(@RequestBody SalesPerson salesPerson, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(salesPerson.getSalesPersonID() != null){
            log.warn("Trying to create a user with id");
            System.out.println("Trying to create a user with id");
            return ResponseEntity.badRequest().build();
        }
        SalesPerson result = salesPersonRepository.save(salesPerson);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/users")
    public ResponseEntity<SalesPerson> update(@RequestBody SalesPerson salesPerson){
        if(salesPerson.getSalesPersonID() == null ){
            log.warn("Trying to update a non existent user");
            return ResponseEntity.badRequest().build();
        }
        if(!salesPersonRepository.existsById(salesPerson.getUserId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        SalesPerson result = salesPersonRepository.save(salesPerson);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/salesPerson")
    public ResponseEntity<SalesPerson> delete(@PathVariable Long salesPersonId) {
        if (!salesPersonRepository.existsById(salesPersonId)) {
            log.warn("Trying to delete a non existent user");
            return ResponseEntity.notFound().build();
        }
        salesPersonRepository.deleteById(salesPersonId);
        return ResponseEntity.ok().build();
    }
}