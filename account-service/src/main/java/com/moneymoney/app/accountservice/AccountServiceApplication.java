package com.moneymoney.app.accountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.moneymoney.app.accountservice.entity.CurrentAccount;
import com.moneymoney.app.accountservice.entity.SavingsAccount;
import com.moneymoney.app.accountservice.repo.AccountRepository;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */

	@Bean
	public CommandLineRunner commandLineRunner(AccountRepository repository) {
		return(args)->{
			repository.save(new SavingsAccount(101, "Shubham", 15000.00, true));
			repository.save(new SavingsAccount(102, "Kanak", 25000.00, true));
			repository.save(new SavingsAccount(103, "Tejas", 6000.00, false));
			repository.save(new CurrentAccount(104,"Tushar",12000.00,5000.00));
			repository.save(new SavingsAccount(105, "Shailaja", 2000.00, true));
			repository.save(new SavingsAccount(106, "Deepika", 5000.00, false));
			repository.save(new CurrentAccount(107,"Rohan",12000.00,5000.00));
		};
	
	};


}

