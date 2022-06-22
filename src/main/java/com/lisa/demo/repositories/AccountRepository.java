package com.lisa.demo.repositories;


import com.lisa.demo.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select acc from Account acc left join fetch acc.transactions  where acc.id=:accountId")
    Optional<Account> findAccountAndRelatedTransactionsByAccountId(@Param("accountId") Long accountId);
}