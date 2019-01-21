package com.moneymoney.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.moneymoney.web.entity.Transaction;
import com.moneymoney.web.transactionservice.dataset.DataSet;

@Controller
public class BankAppController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String depositForm() {
		return "DepositForm";
	}

	@RequestMapping("/deposit")
	public String deposit(@ModelAttribute Transaction transaction, Model model) {
		restTemplate.postForEntity("http://localhost:9090/transactions/deposit", transaction, null);
		model.addAttribute("message", "Success!");
		return "DepositForm";
	}

	@RequestMapping("/withdraw")
	public String withdrawForm() {
		return "WithdrawForm";
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public String withdraw(@ModelAttribute Transaction transaction, Model model) {
		restTemplate.postForEntity("http://localhost:9090/transactions/withdraw", transaction, null);
		model.addAttribute("message", "Success!");
		return "WithdrawForm";
	}

	@RequestMapping("/fundTransfer")
	public String fundTransfer() {
		return "FundTransferForm";
	}

	@RequestMapping(value = "/fundTransfer", method = RequestMethod.POST)
	public String fundTransfer(@RequestParam("senderAccountNumber") int senderAccountNumber,
			@RequestParam("receiverAccountNumber") int receiverAccountNumber, @RequestParam("amount") int amount,
			Model model) {
		restTemplate.postForEntity("http://localhost:9090/transactions/fundTransfer?sender=" + senderAccountNumber
				+ "&receiver=" + receiverAccountNumber + "&amount=" + amount, null, null);
		model.addAttribute("message", "Success!");
		return "FundTransferForm";
	}

	@RequestMapping("/statement")
	public String statement(Model model) {

		ResponseEntity<DataSet> dataset = restTemplate
				.getForEntity("http://localhost:9090/transactions?offset=0&size=5", DataSet.class);
		model.addAttribute("dataset", dataset.getBody());
		return "Statement";
	}

}
