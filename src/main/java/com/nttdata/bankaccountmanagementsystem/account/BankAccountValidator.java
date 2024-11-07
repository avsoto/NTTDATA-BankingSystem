package com.nttdata.bankaccountmanagementsystem.account;

import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.entity.ClientRegistry;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.UUID;

public class BankAccountValidator {

    /** Validate that the client exists in the system before opening the bank account
     * */
    public static void validateClientExists(String dni) {
        Client client = ClientRegistry.getClientByDni(dni);
        if (client == null) {
            throw new BusinessException("The client with ID" + dni + "is not registered.");
        }
    }

    /** Generate a unique account number
     */
    public static String generateAccountNumber() {
        return UUID.randomUUID().toString();
    }
}
