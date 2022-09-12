package com.alwa.annualleavewebapp.repository;

import com.alwa.annualleavewebapp.entities.UserForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserForm, Long> {

}
