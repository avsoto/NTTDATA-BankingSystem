package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

/**
 * Represents a checking account in the Bank Account Management System.
 * <p>
 * This class extends {@link BankAccount} and provides specific behavior for checking accounts,
 * including an overdraft limit that allows withdrawals beyond the account's balance up to a defined limit.
 * </p>
 */
public class CheckingAccount extends BankAccount{

    /**
     * The overdraft limit for checking accounts.
     * <p>
     * This limit defines how much the account can go below zero, with a maximum overdraft of -500.00.
     * </p>
     */
    private static final double OVERDRAFT_LIMIT = -500.00;

    public CheckingAccount(String accountNumber, double balance, Client client) {
        super(accountNumber, balance, AccountType.CHECKING, client);
    }

    /**
     * Withdraws a specified amount from the checking account.
     * <p>
     * The withdrawal is subject to the following conditions:
     * <ul>
     *   <li>The withdrawal amount must be positive.</li>
     *   <li>The account balance plus the overdraft limit must be sufficient to cover the withdrawal.</li>
     * </ul>
     * </p>
     */
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

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", client=" + client +
                '}';
    }
}
