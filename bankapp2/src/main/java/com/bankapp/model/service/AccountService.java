package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.dao.Account;

public interface AccountService {
	public List<Account> getAllAccounts();
	public void transfer(int fromAccId, int toAccountId, double amount);
	public Account addAccount(Account account);
	public Account updateAccount(Account account);
	public Account deleteAccount(int accountId);
	public Account findAccountById(int accountId);
}