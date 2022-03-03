package com.codercampus.Assignment11.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionService transactionService;

	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		List<Transaction> populatedTransactions = transactionRepository.findAll();
		Collections.sort(populatedTransactions);
		model.put("transactions", populatedTransactions);
		return "transactions";
		
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getTransaction(@PathVariable Long transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		System.out.println(transaction);
		model.put("transaction", transaction);	
		return "transaction";
		
	}
	
}
