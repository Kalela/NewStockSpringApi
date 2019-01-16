package com.kalela.newstock.repositories;

import com.kalela.newstock.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
}