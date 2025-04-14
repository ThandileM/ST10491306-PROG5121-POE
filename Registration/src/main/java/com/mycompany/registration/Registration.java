/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
public class Registration {

    public static void main(String[] args) {
       
        String firstName ;
        String lastName;
        String username = null ;
        String password = null ;
        String cellphoneNumber = null;

        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
       
        System.out.print("Enter Last name: ");
        lastName = scanner.nextLine();

        // Validate username
        boolean isValidUsername = false;
        while (!isValidUsername) {
            System.out.println("Enter username (must contain an underscore and be no more than 5 characters): ");
            username = scanner.nextLine();
            if (username.contains("_") && username.length() <= 5) {
                isValidUsername = true;
            } else {
                System.out.println("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters.");
            }
        }

        // Validate password
        boolean isValidPassword = false;
        while (!isValidPassword) {
            System.out.println("Enter password (must contain a capital letter, a special character, a number, and be no more than 8 characters): ");
            password = scanner.nextLine();
            if (isValidPassword(password)) {
                isValidPassword = true;
            } else {
                System.out.println("Password is incorrectly formatted. Please ensure that the password contains at least one capital letter, a number, a special character, and is no more than 8 characters.");
            }
        }

        // Validate cellphone number
        boolean isValidCellphoneNumber = false;
        while (!isValidCellphoneNumber) {
            System.out.println("Enter cellphone number (must start with +27 and be 12 digits): ");
            cellphoneNumber = scanner.nextLine();
            if (isValidCellphoneNumber(cellphoneNumber)) {
                isValidCellphoneNumber = true;
            } else {
                System.out.println("Cellphone is incorrectly formatted or does not contain the international code.");
            }
        }

        System.out.println("Cellphone Number successfully added");
       // System.out.println("Welcome " + firstName + " " + lastName + ", " + "it is great to have you back!");
       
       
        // Login phase
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\n=== User Login ===");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

           

            // Check if the entered details match the registered ones
            if (loginUsername.equals(username) &&
                loginPassword.equals(password))
                 {
                loggedIn = true;
                System.out.println("Welcome " + firstName + " " + lastName + " " + "it is great to have you back!");
            } else {
                System.out.println("Username or password incorrect,please try again");
            }
        }

        scanner.close();
    }

   
    private static boolean isValidPassword(String password) {
        if (password.length() ==12) {
            return false; // Password length must not exceed 8 characters
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        String specialCharacters = "@#$%^&+=!";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (specialCharacters.indexOf(ch) >= 0) hasSpecialChar = true;
        }

        return hasUpperCase && hasDigit && hasSpecialChar;
    }

    // Method to check if cellphone number is valid (starts with +27 and has 12 digits)
    private static boolean isValidCellphoneNumber(String cellphone) {
        if (cellphone.length() != 12) {
            return false;
        }
        if (!cellphone.startsWith("+27")) {
            return false; // Cellphone must start with +27
        }

        // Check that all characters after +27 are digits
        for (int i = 3; i < cellphone.length(); i++) {
            if (!Character.isDigit(cellphone.charAt(i))) {
                return false;
            }
        }

        return true; // Cellphone is valid
    }
}