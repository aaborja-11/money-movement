package com.aborja.moneymovement.accounts.persistence;


import com.aborja.moneymovement.accounts.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

    @Query("SELECT a FROM Account a WHERE a.credentials.username = :username")
    Optional<Account> findByUsername(@Param("username") String username);

}
