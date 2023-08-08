package fr.store.shop.queries.entities;

import fr.store.shop.commonapi.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    private String accountid;
    private String currency;
    private double balance;
    private AccountStatus status;

}
