package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.entity.ClientRegistry;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.UUID;

/**
 * Utility class for validating and managing bank account-related operations.
 * <p>
 * This class provides methods for validating that a client exists in the system before creating a bank account
 * and for generating unique account numbers for new bank accounts.
 * </p>
 */
public class BankAccountValidator {

    /**
     * Validates that the client exists in the system before proceeding with bank account creation.
     * <p>
     * This method checks if a client with the provided DNI exists in the client registry.
     * If no such client is found, a {@link BusinessException} is thrown.
     * </p>
     *
     * @param dni The DNI of the client to validate.
     * @throws BusinessException If the client with the provided DNI does not exist in the system.
     */
    public static void validateClientExists(String dni) {
        Client client = ClientRegistry.getClientByDni(dni);
        if (client == null) {
            throw new BusinessException("The client with ID" + dni + "is not registered.");
        }
    }

    /**
     * Generates a unique account number using a UUID.
     * <p>
     * This method generates a universally unique identifier (UUID) to be used as the account number for new bank accounts.
     * </p>
     *
     * @return A unique account number as a {@link String}.
     */
    public static String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }
}
