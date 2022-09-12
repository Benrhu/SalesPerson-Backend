package com.grouzy.Backend.Services;

import com.grouzy.Backend.Entities.User;
import com.grouzy.Backend.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repo;
    private List<User> users = new ArrayList();


    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public Optional<User> findById(long id) {
        return repo.findById(id);
    }

}
