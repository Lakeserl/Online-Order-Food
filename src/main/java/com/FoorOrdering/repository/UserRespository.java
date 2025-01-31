package com.FoorOrdering.repository;

import com.FoorOrdering.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {

    public User findByEmail(String username);
}
