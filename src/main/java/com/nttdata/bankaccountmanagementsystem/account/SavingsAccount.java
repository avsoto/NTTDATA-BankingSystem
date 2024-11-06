package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountNumber, double balance, Client client) {
        super(accountNumber, balance, AccountType.SAVINGS, client);
    }

    @Override
    public void withdraw(double amount) throws BusinessException {
        if (amount <= 0) {
            throw new BusinessException("The amount to be withdrawn must be positive");
        }
        if (this.balance - amount < 0) {
            throw new BusinessException("Savings accounts cannot have a negative balance.");
        }
        this.balance -= amount;
    }
}
