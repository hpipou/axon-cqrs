package fr.store.shop.queries.repository;

import fr.store.shop.queries.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, String> {
}
