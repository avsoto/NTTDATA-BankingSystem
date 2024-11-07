package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

/**
 * Abstract base class representing a generic bank account.
 * <p>
 * This class serves as the foundation for specific types of bank accounts such as
 * checking or savings accounts. It defines common properties such as the account number,
 * balance, account type, and the associated client. It also provides methods for depositing
 * and withdrawing money, which can be customized by the specific account types.
 * </p>
 */
public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    /** The type of account (e.g., SAVINGS, CHECKING) */
    protected AccountType accountType;

    /** The client associated with this bank account */
    protected Client client;

    public BankAccount(String accountNumber, double balance, AccountType accountType, Client client) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }


    /**
     * Abstract method for withdrawing a specified amount from the bank account.
     * <p>
     * This method must be implemented by subclasses of {@code BankAccount} to define how
     * the withdrawal is processed based on the specific account type.
     * </p>
     *
     * @param amount The amount to be withdrawn.
     * @throws BusinessException If the withdrawal amount is invalid or exceeds the available balance.
     */
    public abstract void withdraw(double amount) throws BusinessException;


    /**
     * Deposits a specified amount into the bank account.
     * <p>
     * If the deposit amount is positive, it will be added to the account's balance.
     * If the amount is zero or negative, a {@link BusinessException} will be thrown.
     * </p>
     *
     * @param amount The amount to be deposited.
     * @throws BusinessException If the deposit amount is invalid (zero or negative).
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new BusinessException("The amount to be deposited must be positive");
        }
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", client=" + client +
                '}';
    }
}
