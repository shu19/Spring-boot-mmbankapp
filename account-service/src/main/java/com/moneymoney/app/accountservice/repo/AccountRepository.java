package com.moneymoney.app.accountservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moneymoney.app.accountservice.entity.Account;

public interface AccountRepository extends MongoRepository<Account, Integer>{
	

}
