package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

public class CheckingAccount extends BankAccount{
    private static final double OVERDRAFT_LIMIT = -500.00;

    public CheckingAccount(String accountNumber, double balance, Client client) {
        super(accountNumber, balance, AccountType.CHECKING, client);
    }

    @Override
    public void withdraw(double amount) throws BusinessException {
        if (amount <= 0) {
            throw new BusinessException("The amount to be withdrawn must be positive.");
        }

        if (this.getBalance() + OVERDRAFT_LIMIT < amount) {
            throw new BusinessException("Insufficient funds, including overdraft limit.");
        }

        // Make the withdrawal
        this.balance -= amount;
    }

    // Method to obtain the overdraft limit, if necessary
    public static double getOverdraftLimit() {
        return OVERDRAFT_LIMIT;
    }
}
