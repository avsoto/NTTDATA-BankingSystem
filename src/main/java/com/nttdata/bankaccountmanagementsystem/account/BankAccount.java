package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected AccountType accountType;

    protected Client client;

    public BankAccount(String accountNumber, double balance, AccountType accountType, Client client) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Client getClient() {
        return client;
    }

    // Abstract method that must be implemented by each type of account
    public abstract void withdraw(double amount) throws BusinessException;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new BusinessException("The amount to be deposited must be positive");
        }
        this.balance += amount;
    }



}
