package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class User implements Record{                      
    private String name, userID, password, email, contact;
    private static FileAccess userFile = new FileAccess("user.txt");
    private Role role;
    
    public User(String userID, String name, String password, String email, String contact,String role){
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.role = Role.valueOf(role);
    }
    public User(String userID, String password){
        this.userID = userID;
        this.password = password;
    }
    public User(){
        
    }
    public void add() throws IOException{
        userFile.addToFile(toString());
    }
    public void edit(Object newData) throws IOException{
        userFile.editFile(toString(), newData.toString());
    }
    public void remove() throws IOException{
        userFile.removeFromFile(toString());
    }
    public static ArrayList<String[]> view() throws IOException{
        return userFile.viewFile();
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL,String filter) throws IOException{
        return userFile.viewFile(AL,filter);
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL, int attIndex, String filter){
        return userFile.viewFile(AL, attIndex, filter);
    }
    public static String generateID() throws IOException,NumberFormatException{
       ArrayList<String[]> AL = view();
        if (AL.isEmpty()){
            return "U0001";
        } else{
            for (int i = 0; i<=AL.size();i++){
                String id = "U";
                String idNo = String.valueOf((i+1));
                
                for (int j = 0; j < (4-idNo.length()); j++){
                    id += "0";
                }
                id += idNo;
                System.out.println(id);
                if (userFile.verifyDataUniqueness(id)){
                    return id;
                }
            }
            return null;
        }
    }
    public String toString(){
        return(userID + "|" + name + "|" + password + "|" + email + "|" + contact+ "|" + role);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void setRole(String role){
        this.role = Role.valueOf(role);
    }
    public String getRole(){
        return role.toString();
    }
    public String[] login() throws IOException{
        ArrayList<String[]> content = view();

        for (String[] line:content){
            if (userID.matches(line[0])){
                if(password.matches(line[2])){
                    return line;
                }
            }
        }
        return null;
    }
    public boolean verifyUniqueness()throws IOException{
       String[] data = {userID,name};
       int[] i = {0,1};
       return userFile.verifyDataUniqueness(data, i);  
    }
}        