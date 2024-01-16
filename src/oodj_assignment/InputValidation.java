/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;


public class InputValidation {
    public static void main(String[] args){
        if (isValidDate("29","9","2023")){
            System.out.println("yes");
                    
        }
    }
    
    public static boolean isValidDate(String day,String month,String year){
        int dayInt = Integer.parseInt(day);
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);
        try {
            LocalDate date = LocalDate.of(yearInt, monthInt, dayInt);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static boolean isValidName(String name) {
        return (name!=null) && (!name.isEmpty()) && (name.length()<=30)&&(!name.contains("|"));
    }

    public static boolean isValidQuantity(String quantity) {
        try{
            if (Integer.parseInt(quantity) >= 0){
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
        
    }

    public static boolean isValidPrice(String price) {
        try{
            if (Double.parseDouble(price) >= 0.00){
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
            return false;
        }
    }
    public static boolean isValidPassword(String password) {
        return ((password.length()>=6) &&(!password.contains("|")));
    }
    
    public static boolean isValidEmail(String email) {
        return (email!=null) && (!email.isEmpty()) && (email.contains("@")) && (email.indexOf("@") !=0)&&(!email.contains("|"));
    }
    
    public static boolean isValidContact(String contact) {
        return (contact!=null) && (!contact.isEmpty()) && (contact.length()<=11) && (contact.length()>=10)&&(!contact.contains("|"));
    }
}