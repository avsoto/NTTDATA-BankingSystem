package com.nttdata.bankaccountmanagementsystem.inputManager;

import java.util.Scanner;

/**
 * This class handles the input from the console for the Bank Account Management System.
 * It provides methods to prompt the user for input and retrieve their responses.
 *
 * <p>
 * The class utilizes a {@link Scanner} object to read user input from the command line.
 * It includes methods to display prompts and capture user input as strings.
 * </p>
 *
 */
public class ConsoleInputManager {
    private Scanner scanner;

    /**
     * Constructor that initializes the scanner object to read input from the console.
     */
    public ConsoleInputManager() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays a prompt to the user and reads the user's input from the console.
     *
     * @param prompt The message to be displayed to the user before taking input.
     * @return The input provided by the user as a {@link String}.
     */
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

}
