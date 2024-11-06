package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ClientValidator {

    public static void validateUniqueDni(String dni, Map<String, Client> clients) {
        if (clients.containsKey(dni)) {
            throw new BusinessException("A client with this DNI already exists.");
        }
    }

    // Validates the email format
    public static void validateEmailFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new BusinessException("Invalid email format.");
        }
    }

    // Validates that all required fields are present
    public static void validateRequiredFields(Client client) {
        if (client.getName() == null || client.getName().isEmpty()) {
            throw new BusinessException("Name is required.");
        }

        if (client.getLastName() == null || client.getLastName().isEmpty()) {
            throw new BusinessException("LastName is required.");
        }

        if (client.getDni() == null || client.getDni().isEmpty()) {
            throw new BusinessException("DNI is required.");
        }

        if (client.getDni().length() != 8) {
            throw new BusinessException("DNI must be 8 characters.");
        }

        if (client.getEmail() == null || client.getEmail().isEmpty()) {
            throw new BusinessException("Email is required.");
        }
    }
}
