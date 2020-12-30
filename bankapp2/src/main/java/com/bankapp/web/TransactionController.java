package com.bankapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.beans.TransferBean;
//......../mgr/transfer
@RestController
@RequestMapping(path = "mgr")
public class TransactionController {
	private AccountService accountService;

	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping(path="transfer", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public String transferFund( @RequestBody TransferBean bean) {
		accountService.transfer(bean.getFromAccountId(), bean.getToAccountId(), bean.getAmount());
		return "fund is transferred";
	}
	
}
