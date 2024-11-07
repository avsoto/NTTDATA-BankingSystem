package com.nttdata.bankaccountmanagementsystem.entity;

import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.regex.Pattern;


/**
 * This class provides static methods for validating client data in the Bank Account Management System.
 * It ensures that client information such as DNI, email, and required fields adhere to specific rules.
 *
 * <p>
 * The validation methods help enforce business rules such as ensuring that the DNI is unique,
 * the email format is correct, and that all required fields are present and valid.
 * </p>
 *
 */
public class ClientValidator {

    /**
     * Validates that the provided DNI (National Identity Document) is unique in the system.
     *
     * @param dni The DNI to be checked for uniqueness.
     * @throws BusinessException If a client with the provided DNI already exists.
     */
    public static void validateUniqueDni(String dni) {
        if (ClientRegistry.getClients().containsKey(dni)) {
            throw new BusinessException("A client with this DNI already exists.");
        }
    }

    /**
     * Validates the format of the provided email address.
     *
     * @param email The email address to be validated.
     * @throws BusinessException If the email format is invalid.
     */
    public static void validateEmailFormat(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new BusinessException("Invalid email format.");
        }
    }

    /**
     * Validates that all required fields (name, last name, DNI, and email) are provided and valid.
     *
     * @param name The client's name.
     * @param lastName The client's last name.
     * @param dni The client's DNI.
     * @param email The client's email.
     * @throws BusinessException If any required field is missing or invalid.
     */
    public static void validateRequiredFields(String name, String lastName, String dni, String email) {
        validateField(name, "Name");
        validateField(lastName, "LastName");
        validateField(dni, "DNI");
        validateField(email, "Email");

        if (dni.length() != 8) {
            throw new BusinessException("DNI must be exactly 8 characters.");
        }
    }

    /**
     * Validates that a given field is not null or empty.
     *
     * @param field The field value to be checked.
     * @param fieldName The name of the field, used in the error message if validation fails.
     * @throws BusinessException If the field is null or empty.
     */
    private static void validateField(String field, String fieldName) {
        if (field == null || field.isEmpty()) {
            throw new BusinessException(fieldName + " is required.");
        }
    }

}
