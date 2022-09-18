package com.alwa.annualleavewebapp.repository;

import com.alwa.annualleavewebapp.entities.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String message);
    Optional<User> findByPassword(String message);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User find_by_email(String message);

}
