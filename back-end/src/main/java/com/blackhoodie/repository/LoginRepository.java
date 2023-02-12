package com.blackhoodie.repository;

import com.blackhoodie.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Account, Long> {
}
