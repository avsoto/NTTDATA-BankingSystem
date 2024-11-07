package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.HashMap;
import java.util.Map;

public class ClientRegistry {
    private static final Map<String, Client> clients = new HashMap<>();

    /** Static method to register a client
     */
    public static Client register(Client client) {
        try {

            /** First we validate the customer data
             */
            ClientValidator.validateRequiredFields(client);
            ClientValidator.validateEmailFormat(client.getEmail());
            ClientValidator.validateUniqueDni(client.getDni(), clients);

            /** If it passes validations, we add it to the registry
             */
            clients.put(client.getDni(), client);
            return client;

        } catch (BusinessException e) {
            System.out.println("Error registering customer: " + e.getMessage());
            throw e;
        }
    }

    /** Getter method to get the Map of clients
     */
    public static Map<String, Client> getClients() {
        return clients;
    }

    /** Method to obtain a client by their ID
     */
    public static Client getClientByDni(String dni) {
        return clients.get(dni);
    }
}
