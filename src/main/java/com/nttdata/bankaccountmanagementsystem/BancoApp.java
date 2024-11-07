package com.nttdata.bankaccountmanagementsystem;

import com.nttdata.bankaccountmanagementsystem.account.*;
import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.entity.ClientManager;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;
import com.nttdata.bankaccountmanagementsystem.inputManager.ConsoleInputManager;

/**
 * This is the main application class for the Bank Account Management System.
 * It is responsible for managing the flow of client registration, account creation,
 * displaying client and account data, and performing account operations.
 *
 * <p>
 * The application registers a new client, creates a bank account for that client,
 * adds the account to the client's data, and allows for basic account operations.
 * </p>
 *
 * <p>
 * In case of any business exceptions during the process, an error message is displayed.
 * </p>
 *
 */
public class BancoApp {
    public static void main(String[] args) {
        ConsoleInputManager inputManager = new ConsoleInputManager();

        try {
            //Process the client registration
            Client client = ClientManager.processClientRegistration(inputManager);
            System.out.println("--- Registered client data: ---");
            System.out.println(client);

            // Create an account for the client
            BankAccount account = AccountManager.createAccount(client, inputManager);

            // If the account is created, add it to the client
            if (account != null) {
                client.addAccount(account);
                System.out.println("Account added to customer.");
            }

            // Display the client and account data
            System.out.println("--- Customer data with accounts ---");
            System.out.println(client);
            for (BankAccount acc : client.getAccounts()) {
                System.out.println(acc);
            }

            // Perform operations on the account
            AccountManager.performAccountOperations(account);

        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    }