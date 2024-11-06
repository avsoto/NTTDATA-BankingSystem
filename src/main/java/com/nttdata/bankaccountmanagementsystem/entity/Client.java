package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.account.BankAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

    private static final Map<String, Client> clients = new HashMap<>();

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

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
