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
        Scanner scanner = new Scanner (System.in);
        
        //Registration
       
        System.out.println("Enter Username(must contain an underscore and is no more than five charcters in length):");
        String  Username = scanner.nextLine();
           
        System.out.println("Enter password(must contain a capital letter,a number, a special charcter and must at least be eight characters):");
        String Password = scanner.nextLine();
        
        System.out.println("Enter CellPhoneNumber(must start with +27)");
        String cellPhoneNumber = scanner.nextLine();
        
        String registrationMessage = registerUser(Username, Password, cellPhoneNumber);
        System.out.println(registrationMessage);
        
        //Successful registration

        if(registrationMessage.equals("Registration succesful!"))
            
        //Login User
        
       System.out.println("Login");
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            String loginMessage = loginUser(username);
            System.out.println(loginMessage);
        
        
       scanner.close();
    }

   

} 
          