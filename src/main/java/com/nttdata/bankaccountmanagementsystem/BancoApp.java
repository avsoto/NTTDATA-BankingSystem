package com.nttdata.bankaccountmanagementsystem;

import com.nttdata.bankaccountmanagementsystem.account.BankAccount;
import com.nttdata.bankaccountmanagementsystem.account.BankAccountValidator;
import com.nttdata.bankaccountmanagementsystem.account.CheckingAccount;
import com.nttdata.bankaccountmanagementsystem.database.DataBaseConnection;
import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.account.SavingsAccount;
import com.nttdata.bankaccountmanagementsystem.entity.ClientRegistry;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.sql.Connection;

public class BancoApp {
    public static void main(String[] args) {
        /* // I create a client
        Client client = new Client("Ana", "Soto", "12345678", "ana@example.com");

        Client registeredClient = null;
        try {
            // Register the client, if valid
            registeredClient = ClientRegistry.register(client);
        } catch (BusinessException e) {
            System.out.println("Error in client registration: " + e.getMessage());
            return; // Exit the program if registration fails
        }

        if (registeredClient != null) {
            // Create a savings account with an initial balance
            SavingsAccount savingsAccount = new SavingsAccount(BankAccountValidator.generateAccountNumber(), 1000.00, registeredClient);
            registeredClient.addAccount(savingsAccount);

            // Create a current account with initial balance
            CheckingAccount checkingAccount = new CheckingAccount(BankAccountValidator.generateAccountNumber(), 1500.00, registeredClient);
            registeredClient.addAccount(checkingAccount);

            // Try to make a withdrawal from the savings account
            try {
                System.out.println("Initial balance in the savings account: " + savingsAccount.getBalance());
                savingsAccount.withdraw(300.00);  // Successful withdrawal
                System.out.println("Balance after withdrawal in savings account: " + savingsAccount.getBalance());
            } catch (BusinessException e) {
                System.out.println("Error in savings account: " + e.getMessage());
            }

            // Attempting to make a withdrawal that exceeds the balance in the savings account
            try {
                savingsAccount.withdraw(800.00);  // Withdrawal that must fail
            } catch (BusinessException e) {
                System.out.println("Error in savings account: " + e.getMessage());
            }

            // Try to make a withdrawal from the current account
            try {
                System.out.println("\nInitial balance in the current account: " + checkingAccount.getBalance());
                checkingAccount.withdraw(900.00);  // Successful withdrawal within overdraft limit
                System.out.println("Balance after withdrawal in the current account: " + checkingAccount.getBalance());
            } catch (BusinessException e) {
                System.out.println("Error in current account: " + e.getMessage());
            }

            // Check the final balances for both accounts
            System.out.println("\nFinal balances:");
            registeredClient.getAccounts().forEach(account ->
                    System.out.println("Account " + account.getAccountNumber() + " (" + account.getAccountType() + "): Balance = " + account.getBalance())
            );
        } else {
            System.out.println("Client registration failed. Accounts cannot be added.");
        }*/

        Connection connection = DataBaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Successful connection to the database.");
        } else {
            System.out.println("Error connecting to database.");
        }
    }
}