/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_2;

/**
 *
 * @author RC_Student_lab
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
    private static int messageCount = 0;
    private static List<String> messageHistory = new ArrayList<>();

    static String getFormattedMessages() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    private String messageID;
    private String recipient;
    private String content;
    private String messageHash;
    
    public Message(String recipient, String content){
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.content = content;
        this.messageHash = createMessageHash();
        messageCount++;
        storeMessage(); 
    }
    String generateMessageID(){
        Random rand = new Random();
        long num = 1000000000L + (long)(rand.nextDouble()*9000000000L);
        return String.valueOf(num);
    }
    public boolean checkMessageID(){return this.messageID.length()<=10;}
    
    public static boolean checkRecipientCell(String number){
        return number != null && number.trim().matches("\\+27\\d{9}");
    }
    private String createMessageHash(){
        String[]words = this.content.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return this.messageID.substring(0,2) + ":" + messageCount + firstWord + lastWord;
    }
    public static boolean sendMessageOption(String option){return option.equals("1");}
    
    public static void printMessage(){
        if (messageHistory.isEmpty()){
            System.out.println("No messages have been sent.");
        }else {
            for(String msg : messageHistory){
                System.out.println(msg);
                System.out.println("---------------------");
            }
        }
    }
    public static int returnTotalMessages(){return messageCount;}
    
    
    private void storeMessage() {
        JSONObject messageJson = new JSONObject();
        messageJson.put("MessageID", messageID);
        messageJson.put("MessageHash", messageHash);
        messageJson.put("Recipient", recipient);
        messageJson.put("Content", content);
    
        try(FileWriter file = new FileWriter("messages.json", true)){
            file.write(messageJson.toString());
        }catch(IOException e){
            System.out.println("Error writing message to JSON: " + e.getMessage());
        }   
    
    }
}

