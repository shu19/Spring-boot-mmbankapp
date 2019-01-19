package com.moneymoney.app.transactionservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moneymoney.app.transactionservice.entity.Transaction;
import com.moneymoney.app.transactionservice.service.TransactionService;


@RestController
@RequestMapping("/transactions")
public class TransactionResource {

	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	private TransactionService service;
	
	@PostMapping
	public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction){
		
		ResponseEntity<Double> entity=restTemplate.getForEntity("http://localhost:8989/accounts/"+transaction.getAccountNumber()+"/balance", Double.class);
		
		if(entity.getStatusCode()==HttpStatus.OK) {
			System.out.println("Balance is "+entity.getBody());
			service.deposit(transaction.getAccountNumber(),transaction.getAmount(),transaction.getTransactionDetails());
		}
		return null;
		
		
	}
}
