package com.nttdata.bankaccountmanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class Client {

    private static final Map<String, Client> clients = new HashMap<>();

    private String name;
    private String lastName;
    private String dni;
    private String email;

    private Client(String name, String lastName, String dni, String email) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
    }

    public static Client register(String name, String lastName, String dni
    , String email){
        Client client = new Client(name, lastName, dni
        ,email);
        clients.put(dni, client);

        return client;
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
}
