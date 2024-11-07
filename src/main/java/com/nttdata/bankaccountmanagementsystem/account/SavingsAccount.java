package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

/**
 * Represents a savings account in the Bank Account Management System.
 * <p>
 * This class extends {@link BankAccount} and provides specific behavior for savings accounts,
 * including withdrawal restrictions that ensure the account balance cannot go negative.
 * </p>
 */
public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountNumber, double balance, Client client) {
        super(accountNumber, balance, AccountType.SAVINGS, client);
    }

    /**
     * Withdraws a specified amount from the savings account.
     * <p>
     * The withdrawal is subject to the following conditions:
     * <ul>
     *   <li>The withdrawal amount must be positive.</li>
     *   <li>The account balance cannot go below zero.</li>
     * </ul>
     * </p>
     *
     * @param amount The amount to withdraw.
     * @throws BusinessException If the withdrawal amount is not positive or if it would result in a negative balance.
     */
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

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", client=" + client +
                '}';
    }
}
