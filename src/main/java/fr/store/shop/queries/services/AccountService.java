package fr.store.shop.queries.services;

import fr.store.shop.commonapi.events.AccountCreatedEvent;
import fr.store.shop.queries.entities.Account;
import fr.store.shop.queries.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event){
        Account account= new Account(
                event.getId(),
                event.getCurrency(),
                event.getBalance(),
                event.getStatus()
        );
        accountRepository.save(account);
    }

    @QueryHandler
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

}
