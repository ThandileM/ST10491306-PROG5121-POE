/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
package com.mycompany.poe_2;

/**
 *
 * @author RC_Student_lab
 */


import javax.swing.JOptionPane;

public class POE_2 {

    //  validate password
    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*\\d).{1,8}$");
    }

    //  validate cellphone number
    public static boolean isValidCellphoneNumber(String number) {
        return number.matches("^\\+27\\d{9}$");
    }

    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        if (firstName == null) return;

        String lastName = JOptionPane.showInputDialog("Enter last name:");
        if (lastName == null) return;

        // Validate username
        String username = "";
        boolean isValidUsername = false;
        while (!isValidUsername) {
            username = JOptionPane.showInputDialog("Enter username (must contain an underscore and be no more than 5 characters):");
            if (username == null) 
                return;
            if (username.contains("_") && username.length() <= 5) {
                isValidUsername = true;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters.");
            }
        }

        // Validate password
        String password = "";
        boolean isValidPassword = false;
        while (!isValidPassword) {
            password = JOptionPane.showInputDialog("Enter password (must contain a capital letter, a special character, a number, and be no more than 8 characters):");
            if (password == null) return;
            if (isValidPassword(password)) {
                isValidPassword = true;
            } else {
                JOptionPane.showMessageDialog(null, "Password is incorrectly formatted. Please ensure that the password contains at least one capital letter, a number, a special character, and is no more than 8 characters.");
            }
        }

        // Validate cellphone number
        String cellphoneNumber = "";
        boolean isValidCellphoneNumber = false;
        while (!isValidCellphoneNumber) {
            cellphoneNumber = JOptionPane.showInputDialog("Enter cellphone number (must start with +27 and be 12 digits):");
            if (cellphoneNumber == null) return;
            if (isValidCellphoneNumber(cellphoneNumber)) {
                isValidCellphoneNumber = true;
            } else {
                JOptionPane.showMessageDialog(null, "Cellphone is incorrectly formatted or does not contain the international code.");
            }
        }

        JOptionPane.showMessageDialog(null, "Cellphone Number successfully added");
       

        Login login = new Login(username, password, firstName, lastName, cellphoneNumber);
        String registrationResult = login.registerUser();
        JOptionPane.showMessageDialog(null, registrationResult);

        

        // Login phase
        boolean loggedIn =  false;
        while(!loggedIn){
       String loginUsername = JOptionPane.showInputDialog( "=== Log In ===\nEnter username");
       String loginPassword = JOptionPane.showInputDialog("Enter password:");

        if ((loginUsername == null || loginPassword == null) ||
                login.loginUser(loginUsername, loginPassword)) {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");
            //return;
        }else{
            loggedIn = true;
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to have you back!");
        }
        runQuickChat();
    }

  
    }

    // Messaging functionality
    private static void runQuickChat() {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");
        boolean running = true;

        while (running) {
            String[] options = {"Send Message", "Show Recent (Coming Soon)", "Quit"};
            int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "QuickChat Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
            );

            switch (choice) {
                case 0 -> {
                    // Send Message
                    String recipient = JOptionPane.showInputDialog("Enter recipient number:");
                    String message = JOptionPane.showInputDialog("Enter message:");

                    if (message != null && message.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters");
                    } else {
                        JOptionPane.showMessageDialog(null, "Message sent" );
                    }
                }

                case 1 -> // Show Recent (Coming Soon)
                    JOptionPane.showMessageDialog(null, "Coming Soon.");

                case 2, JOptionPane.CLOSED_OPTION -> // Quit
                {
                    running = false;
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
                    }
    }
}
