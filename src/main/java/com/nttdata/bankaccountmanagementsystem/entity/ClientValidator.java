package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.Map;
import java.util.regex.Pattern;

public class ClientValidator {

    public static void validateUniqueDni(String dni, Map<String, Client> clients) {
        if (clients.containsKey(dni)) {
            throw new BusinessException("A client with this DNI already exists.");
        }
    }

    /** Validates the email format
     */
    public static void validateEmailFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new BusinessException("Invalid email format.");
        }
    }

    /** Validates that all required fields are present
     */
    public static void validateRequiredFields(Client client) {
        validateField(client.getName(), "Name");
        validateField(client.getLastName(), "LastName");
        validateField(client.getDni(), "DNI");
        validateField(client.getEmail(), "Email");

        if (client.getDni().length() != 8) {
            throw new BusinessException("DNI must be exactly 8 characters.");
        }
    }

    private static void validateField(String field, String fieldName) {
        if (field == null || field.isEmpty()) {
            throw new BusinessException(fieldName + " is required.");
        }
    }

}
