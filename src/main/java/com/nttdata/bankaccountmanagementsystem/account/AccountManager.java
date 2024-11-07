package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;
import com.nttdata.bankaccountmanagementsystem.inputManager.ConsoleInputManager;

/**
 * AccountManager handles the creation and operations of bank accounts.
 * <p>
 * This class provides methods to create bank accounts (savings or checking)
 * for clients and perform common account operations such as deposits,
 * withdrawals, and balance checks.
 * </p>
 */
public class AccountManager {

    /**
     * Creates a new bank account (either savings or checking) for a client.
     * <p>
     * This method asks the user to choose the account type and enter the
     * initial balance for the selected account type. The corresponding
     * account is then created and returned.
     * </p>
     *
     * @param client The client who will own the account.
     * @param inputManager The input manager to handle user input.
     * @return The created BankAccount object, or null if an invalid option was chosen.
     */
    public static BankAccount createAccount(Client client, ConsoleInputManager inputManager) {
        String accountTypeChoice = inputManager.getInput("\nDo you want to create an account? Enter '1' for Savings or '2' for Credit:");

        BankAccount account = null;
        if ("1".equals(accountTypeChoice)) {
            // Savings account
            double balance = Double.parseDouble(inputManager.getInput("Enter initial balance for the savings account:"));
            account = new SavingsAccount(BankAccountValidator.generateAccountNumber(), balance, client);
            System.out.println("Savings account created successfully.");
        } else if ("2".equals(accountTypeChoice)) {
            // Checking account
            double balance = Double.parseDouble(inputManager.getInput("Enter initial balance for the checking account:"));
            account = new CheckingAccount(BankAccountValidator.generateAccountNumber(), balance, client);
            System.out.println("Checking account created successfully.");
        } else {
            System.out.println("Invalid option. No account created.");
        }

        return account;
    }


    /**
     * Performs a series of operations on a bank account, including deposits, withdrawals,
     * and balance checks.
     * <p>
     * This method demonstrates basic account operations by making a deposit, a withdrawal,
     * and checking the balance. It also handles error scenarios such as attempting to withdraw
     * an invalid amount.
     * </p>
     *
     * @param account The bank account on which the operations will be performed.
     * @throws BusinessException If an error occurs during the operation (e.g., insufficient funds).
     */
    public static void performAccountOperations(BankAccount account) throws BusinessException {
        if (account != null) {
            System.out.println("\n--- Performing operations on the account ---");

            // Deposit
            account.deposit(500);
            System.out.println("Deposit of 500 made into the account.");
            System.out.println("The current balance is: " + account.getBalance());

            // Withdrawal
            account.withdraw(260);
            System.out.println("Withdrawal of 260 made from the account.");
            System.out.println("The current balance is: " + account.getBalance());

            // Attempt to withdraw an invalid amount
            try {
                account.withdraw(3000);
            } catch (BusinessException e) {
                System.out.println("Error when withdrawing S/.3000: " + e.getMessage());
            }

            // Check balance
            System.out.println("The current balance is: " + account.getBalance());
        }
    }
}
