package com.moneymoney.app.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneymoney.app.transactionservice.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
