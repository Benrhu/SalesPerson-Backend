package com.grouzy.Backend.Repositories;

import com.grouzy.Backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
