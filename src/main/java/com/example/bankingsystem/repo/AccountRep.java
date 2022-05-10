package com.example.bankingsystem.repo;

import com.example.bankingsystem.entity.Account;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRep extends JpaRepository<Account, Integer> {
    List<Account> findAllByAccountNameContainingIgnoreCase(String name);
}
