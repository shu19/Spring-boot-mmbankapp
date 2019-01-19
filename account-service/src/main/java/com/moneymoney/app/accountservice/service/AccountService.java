package com.moneymoney.app.accountservice.service;

import java.util.List;

import com.moneymoney.app.accountservice.entity.Account;

public interface AccountService {

	List<Account> getAllAccounts();

	Account getAccountById(int accountNumber);

	Double getAccountBalance(int accountNumber);

	void updateBalance(Account account);

	void addNewAccount(Account account);

	void updateAccount(Account account);

}