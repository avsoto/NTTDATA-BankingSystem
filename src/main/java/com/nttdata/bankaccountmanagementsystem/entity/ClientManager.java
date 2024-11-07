package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;
import com.nttdata.bankaccountmanagementsystem.inputManager.ConsoleInputManager;

/**
 * This class manages the client registration process in the Bank Account Management System.
 * It handles the collection of client data, validates the data, and registers the client
 * in the client registry after ensuring all business rules are followed.
 *
 * <p>
 * The registration process includes validating the required fields, checking the email format,
 * ensuring the uniqueness of the client's DNI, and creating the client object if all validations pass.
 * </p>
 *
 */
public class ClientManager {

    /**
     * Processes the client registration by collecting input data, validating it, and
     * registering the client in the system.
     *
     * @param inputManager An instance of {@link ConsoleInputManager} used to collect client data.
     * @return The {@link Client} object if registration is successful, or {@code null} if there is an error.
     * @throws BusinessException If any validation or registration step fails, a {@link BusinessException} is thrown.
     */
    public static Client processClientRegistration(ConsoleInputManager inputManager) throws BusinessException {

        // Collect client data from input user
        String name = inputManager.getInput("Enter the client name: ");
        String lastName = inputManager.getInput("Enter the client last name:");
        String dni = inputManager.getInput("Enter the client DNI:");
        String email = inputManager.getInput("Enter the client email:");


        try {
            // Validate individual fields before creating the client object
            ClientValidator.validateRequiredFields(name, lastName, dni, email);
            ClientValidator.validateEmailFormat(email);
            ClientValidator.validateUniqueDni(dni);

            // Create the client object only if all validations pass
            Client client = new Client(name, lastName, dni, email);

            // Register the client through ClientRegistry
            ClientRegistry.addClientToRegistry(client);

            System.out.println("Client registered successfully.");
            return client;

        } catch (BusinessException e) {
            System.out.println("Error registering client: " + e.getMessage());
            return null; // Handle or return null as needed
        }
    }


}
