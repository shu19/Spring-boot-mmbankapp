package com.moneymoney.app.transactionservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.moneymoney.app.transactionservice.repository.TransactionRepository;

public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;

	@Override
	public void deposit(Integer accountNumber, Double amount, String string) {

		
	}
	
	
}
