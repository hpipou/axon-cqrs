package fr.store.shop.queries.controllers;

import fr.store.shop.queries.entities.Account;
import fr.store.shop.queries.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/account")
public class QueryControllers {

    private AccountService accountService;

    public QueryControllers(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccount();
    }
}
