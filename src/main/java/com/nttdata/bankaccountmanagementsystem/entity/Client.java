package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.account.BankAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a client in the Bank Account Management System.
 *
 * <p>
 * This class contains the personal information of the client (name, last name, DNI, and email)
 * and a list of {@link BankAccount} objects associated with the client. It provides methods
 * to access and modify the client's data, as well as to manage the client's bank accounts.
 * </p>
 */

public class Client {

    private String name;
    private String lastName;
    private String dni;
    private String email;
    private List<BankAccount> accounts = new ArrayList<>();


    public Client(String name, String lastName, String dni, String email) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * Gets the list of bank accounts associated with the client.
     *
     * @return A list of {@link BankAccount} objects associated with the client.
     */
    public List<BankAccount> getAccounts() {
        return accounts;
    }


    /**
     * Adds a bank account to the client's list of accounts.
     *
     * @param account The {@link BankAccount} to be added to the list of accounts.
     *               If the account is {@code null}, it will not be added.
     */
    public void addAccount(BankAccount account) {
        if (account != null) {
            accounts.add(account);
        }
    }
}
