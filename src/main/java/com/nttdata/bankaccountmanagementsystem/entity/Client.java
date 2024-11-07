package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.account.BankAccount;

import java.util.ArrayList;
import java.util.List;

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

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        if (account != null) {
            accounts.add(account);
        }
    }
}
