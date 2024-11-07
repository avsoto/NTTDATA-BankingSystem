package com.nttdata.bankaccountmanagementsystem.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * This class serves as a registry for managing clients in the Bank Account Management System.
 * It provides methods to add clients to the registry, retrieve clients by their DNI,
 * and get the entire registry of clients.
 *
 * <p>
 * The clients are stored in a static {@link Map} where the key is the client's DNI (National Identity Document),
 * and the value is the {@link Client} object associated with that DNI.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 */
public class ClientRegistry {
    private static final Map<String, Client> clients = new HashMap<>();

    /**
     * Static method to register a new client by adding them to the client registry.
     *
     * @param client The client object to be added to the registry.
     */
    public static void addClientToRegistry(Client client) {
        // Add client to the registry
        clients.put(client.getDni(), client);
    }

    /**
     * Getter method to retrieve the entire client registry.
     *
     * @return A {@link Map} containing all the clients, where the key is the client's DNI
     *         and the value is the corresponding {@link Client} object.
     */
    public static Map<String, Client> getClients() {
        return clients;
    }

    /**
     * Method to retrieve a client from the registry by their DNI.
     *
     * @param dni The DNI of the client to be retrieved.
     * @return The {@link Client} object associated with the provided DNI,
     *         or {@code null} if no client with that DNI exists in the registry.
     */
    public static Client getClientByDni(String dni) {
        return clients.get(dni);
    }
}
