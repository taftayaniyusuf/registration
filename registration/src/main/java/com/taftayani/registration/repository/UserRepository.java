package com.taftayani.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taftayani.registration.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
