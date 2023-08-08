package fr.store.shop.commands.aggregate;

import fr.store.shop.commonapi.commands.CreateAccountCommand;
import fr.store.shop.commonapi.enums.AccountStatus;
import fr.store.shop.commonapi.events.AccountCreatedEvent;
import fr.store.shop.commonapi.exceptions.NegativeBalanceException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String accountId;
    private String currency;
    private double balance;
    private AccountStatus status;

    public AccountAggregate(){
        // this for AXON
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand event){
        if(event.getInitialBalance()<0){
            throw new NegativeBalanceException("Negative Balance");
        }

        AggregateLifecycle.apply(new AccountCreatedEvent(
                event.getId(),
                event.getCurrency(),
                event.getInitialBalance(),
                AccountStatus.ACTIVATED
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.accountId      =   event.getId();
        this.balance        =   event.getBalance();
        this.currency       =   event.getCurrency();
        this.status         =   event.getStatus();
    }

}
