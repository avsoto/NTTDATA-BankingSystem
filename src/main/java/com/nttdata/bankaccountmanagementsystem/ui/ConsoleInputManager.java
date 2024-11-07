package com.nttdata.bankaccountmanagementsystem.ui;
import com.nttdata.bankaccountmanagementsystem.entity.Client;
import com.nttdata.bankaccountmanagementsystem.entity.ClientRegistry;
import com.nttdata.bankaccountmanagementsystem.exceptions.BusinessException;

import java.util.Scanner;

public class ConsoleInputManager {
    private Scanner scanner;

    public ConsoleInputManager() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    /** Method to obtain the complete customer data
     */
    public Client getClientData() {
        String name = getInput("Enter the client name: ");
        String lastName = getInput("Enter the client last name:");
        String dni = getInput("Enter the client DNI:");
        String email = getInput("Enter the client email:");

        // We create the client with the entered data
        Client client = new Client(name, lastName, dni, email);

        try {
            /* We use ClientRegistry to register the client
             This method also does the validations internally
             */
            ClientRegistry.register(client);

        } catch (BusinessException e) {
            System.out.println("Error registering client:" + e.getMessage());
            throw e;
        }

        return client;

    }

}
