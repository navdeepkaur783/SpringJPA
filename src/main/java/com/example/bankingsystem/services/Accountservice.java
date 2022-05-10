package com.example.bankingsystem.services;

import com.example.bankingsystem.entity.Account;
import com.example.bankingsystem.repo.AccountRep;
import com.example.bankingsystem.repo.ProfileRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Accountservice {
    private AccountRep rep;
    private ProfileRepo profileRepo;

    public Accountservice(AccountRep rep, ProfileRepo profileRepo) {
        this.rep = rep;
        this.profileRepo = profileRepo;
    }

    public Account createAccount(Account account) {
        return rep.save(account);
    }

    public Optional<Account> getByID(int id) {
        return rep.findById(id);
    }

    public Account updateAccount(Account account) {
        return rep.save(account);
    }

    public List<Account> getAccountByName(String name) {
        return rep.findAllByAccountNameContainingIgnoreCase(name);
    }

    public List<Account> getAll() {
        return rep.findAll();
    }

    public void deleteByID(Optional<Integer> id) {
        if (id.isPresent()) {
            rep.deleteById(id.get());
        }
    }
}
