package com.alwa.annualleavewebapp.repository;

import com.alwa.annualleavewebapp.entities.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String message);
    Optional<User> findUserByPassword(String message);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String username);

    public User findByUsername(String username);
}
