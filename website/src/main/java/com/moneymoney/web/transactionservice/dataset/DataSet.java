package com.moneymoney.web.transactionservice.dataset;

import java.util.List;

import org.springframework.hateoas.Link;

import com.moneymoney.web.entity.Transaction;

public class DataSet {

	private List<Transaction> transactions;
	private Link nextLink;
	private Link previousLink;

	public DataSet() {
		// TODO Auto-generated constructor stub
	}

	public DataSet(List<Transaction> transactions, Link nextLink, Link previousLink) {
		super();
		this.transactions = transactions;
		this.nextLink = nextLink;
		this.previousLink = previousLink;
	}

	public List<Transaction> getTransaction() {
		return transactions;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transactions = transaction;
	}

	public Link getNextLink() {
		return nextLink;
	}

	public void setNextLink(Link nextLink) {
		this.nextLink = nextLink;
	}

	public Link getPreviousLink() {
		return previousLink;
	}

	public void setPreviousLink(Link previousLink) {
		this.previousLink = previousLink;
	}

	@Override
	public String toString() {
		return "DataSet [transaction=" + transactions + ", nextLink=" + nextLink + ", previousLink=" + previousLink
				+ "]";
	}

}
