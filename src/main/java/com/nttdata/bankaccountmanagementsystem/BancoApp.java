package com.nttdata.bankaccountmanagementsystem;

import com.nttdata.bankaccountmanagementsystem.account.BankAccount;
import com.nttdata.bankaccountmanagementsystem.account.BankAccountValidator;
import com.nttdata.bankaccountmanagementsystem.account.CheckingAccount;
import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.account.SavingsAccount;
import com.nttdata.bankaccountmanagementsystem.entity.ClientRegistry;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;
import com.nttdata.bankaccountmanagementsystem.ui.ConsoleInputManager;

import static com.nttdata.bankaccountmanagementsystem.entity.ClientValidator.validateUniqueDni;

public class BancoApp {
    public static void main(String[] args) {

        ConsoleInputManager inputManager = new ConsoleInputManager();

        /** Try to register the client
         */
        try {
            // Get customer data
            Client client = inputManager.getClientData();

            // If everything is correct, we show the success message
            System.out.println("\n Client registered successfully. ");
            System.out.println("--- Registered client data: ---");
            System.out.println(client);

            // Now we ask if the client wants to create an account
            String accountTypeChoice = inputManager.getInput("\nDo you want to create an account? Enter '1' for Savings Account or '2' for Credit Account:");
            BankAccount account = null;

            // Depending on the option, we create the corresponding account
            if ("1".equals(accountTypeChoice)) {
                // Savings account
                double balance = Double.parseDouble(inputManager.getInput("Enter the initial balance of the savings account:"));
                account = new SavingsAccount( BankAccountValidator.generateAccountNumber(), balance, client);
                System.out.println("\nSavings account created successfully.");
            } else if ("2".equals(accountTypeChoice)) {
                // Current (credit) account
                double balance = Double.parseDouble(inputManager.getInput("Enter the initial balance of the credit account:"));
                account = new CheckingAccount(BankAccountValidator.generateAccountNumber(), balance, client);
                System.out.println("\nCredit account created successfully.");
            } else {
                System.out.println("\nInvalid option. No account has been created.");
            }

            // If the account has been created, we add it to the client
            if (account != null) {
                client.addAccount(account);
                System.out.println("\nAccount added to customer.");
            }

            // At the end, print the customer data and their accounts
            System.out.println("\n--- Customer data with accounts ---");
            System.out.println(client);  // Print customer data

            // Print the associated accounts
            if (client.getAccounts().isEmpty()) {
                System.out.println("\nThe client has no registered accounts.");
            } else {
                for (BankAccount acc : client.getAccounts()) {
                    System.out.println(acc);
                }
            }

            // Perform some operations on the account (deposits and withdrawals)
            System.out.println("\n--- Performing operations on the account ---");

            // Deposit into the account
            account.deposit(500);
            System.out.println("\nDeposit of 500 made into the account.");
            System.out.println("The current account balance is: " + account.getBalance());

            // Make a valid withdrawal
            // Call the withdraw() method of CheckingAccount or SavingsAccount
            account.withdraw(260);
            System.out.println("\nWithdrawal of 200 made from the account.");
            System.out.println("The current account balance is: " + account.getBalance());

            // Try to make a withdrawal greater than the balance (should generate an error)
            try {
                account.withdraw(3000);  // Attempted withdrawal with insufficient balance
                System.out.println("\nWithdrawal of 1000 made (should fail).");
            } catch (BusinessException e) {
                System.out.println("\nError when withdrawing S/.3000: " + e.getMessage());
            }

            // Check account balance
            System.out.println("\nThe current account balance is: " + account.getBalance());


        } catch (BusinessException e) {
            // If any validation fails, the exception is caught and the error is displayed
            System.out.println("\nError registering customer or creating account: " + e.getMessage());
        }


        /** Try to register the second client with the same ID to test the validation
         */
        try {
            Client duplicateClient = new Client("Isabel", "Ramirez", "77564700", "mramirez@mail.com");

            // Check if the duplicate client's ID is already registered
            validateUniqueDni(duplicateClient.getDni(), ClientRegistry.getClients());

            // If the DNI is unique, we add it
            ClientRegistry.register(duplicateClient);
            System.out.println("\nCustomer registered successfully: " + duplicateClient);

        } catch (BusinessException e) {
            System.out.println("\nError trying to register duplicate client: " + e.getMessage());
        }

    }
}