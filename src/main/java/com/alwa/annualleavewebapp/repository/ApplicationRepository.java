package com.alwa.annualleavewebapp.repository;

import com.alwa.annualleavewebapp.entities.Application;
import com.alwa.annualleavewebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<User> findById(String message);

}
