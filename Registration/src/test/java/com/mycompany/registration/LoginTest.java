/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registration;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
    
   public class LoginTest {
    private static Login util;
    
    
    @BeforeAll
    public static void setUp() {
        util = new Login("","", "Kyl_1", "Ch&&sec@ke99!","+27838968976");
    
    }
    

    @Test
    public void testGetUsername() {
        assertEquals("Kyl_1",util.getUsername()); 
        util.setUsername("Kyl_1");
    
    }
    
    @Test
    public void testCheckPasswordComplexity() {
        assertEquals("Ch&&sec@ke99!", util.getPassword());
        
        util.setPassword("Ch&&sec@ke99");
      
    }

    @Test
    public void testCheckCellPhoneNumber() {
      util.setCellPhoneNumber("+27838968976");
      assertEquals("+27838968976",util.getCellNumber());
    }
    
    @Test
    public void testRegisterUser(){
        util.setUsername("Kyl_1");
        assertEquals("Kyl_1", util.getUsername());
        util.setPassword("Ch&&secke99!");
        assertEquals("Ch&&seck99!",util.getPassword());
    }
    @Test
    public void testLoginUser(){
        assertTrue(util.checkUsername("kyl_1"));
        assertFalse(util.checkPasswordComplexity("Ch&&secke99!"));
    }

            
}