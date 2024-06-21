package com.myapp.floosy.dao;

import com.myapp.floosy.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findFirstByOrderByIdDesc();
}
