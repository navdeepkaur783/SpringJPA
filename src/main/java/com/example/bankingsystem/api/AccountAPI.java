package com.example.bankingsystem.api;

import com.example.bankingsystem.entity.Account;
import com.example.bankingsystem.entity.AccountType;
import com.example.bankingsystem.exceptions.AccountNotFoundException;
import com.example.bankingsystem.services.Accountservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AccountAPI {
    private Accountservice service;

    public AccountAPI(Accountservice service) {
        this.service = service;
    }
    @GetMapping(value = "/api/account")
    public List<Account> getAll(@RequestParam(value = "AccountType",required = false )AccountType accountType,
                                @RequestParam(value="name", required = false) Optional<String> name)
    {
        if(accountType!=null)
       {
           return service.getAll().stream().filter(a->a.getAccountType()==accountType).collect(Collectors.toList());
       }
        if(name.isPresent()){
            return service.getAccountByName(name.get());
        }
       return service.getAll();
    }


    @PostMapping("/api/account")
    public Account createAccount(@RequestBody Account account){
       return service.createAccount(account);
    }


    @GetMapping("/api/account/{id}")
    public ResponseEntity<?> getByID(@PathVariable("id") Optional<Integer> id){
       Optional<Account> account=service.getByID(id.orElseThrow(()->new IllegalArgumentException("I can't be null")));

       return ResponseEntity.ok(account.orElseThrow(AccountNotFoundException::new));
//        if (account.isPresent()) {
//            ResponseEntity.status(200).header("X-Producer","Navdeep")
//                    .body(account.get() );
//        }
//        return ResponseEntity.status(404).header("X-Fault","NO DATA")
//                .body(ErrorResponse.builder().code(10001).msg("No data found").applicationId("DL1").dateTime(Instant.now()).build());


    }


    @PutMapping("/api/account")
    public Account updateAccount(@RequestBody Account account){
        return service.updateAccount(account);
    }

    @DeleteMapping("/api/account/{id}")
    public void deleteAccount(@PathVariable("id") Optional<Integer> id){
        service.deleteByID(id);
    }
}
