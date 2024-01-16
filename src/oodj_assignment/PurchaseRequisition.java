
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;

public class PurchaseRequisition implements Record {
    private static FileAccess prFile = new FileAccess("pr.txt");
    private String prID,smID;
    private Item item;
    private int quantity;
    private String status = "Pending";
            
    public PurchaseRequisition(String prID,Item item,int quantity,String smID,String status){
        this.prID = prID;
        this.item = item;
        this.quantity = quantity;
        this.smID = smID;
        this.status = status;
    }
    public PurchaseRequisition(String prID,Item item,int quantity){
        this.prID = prID;
        this.item = item;
        this.quantity = quantity;
    }
    public String getPRID(){
        return prID;
    }
    public Item getItem(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }
    public String getStatus(){
        return status;
    }
    public void setSMID(String smID){
        this.smID = smID;
    }
    public String getSMID(){
        return smID;
    }
    public double totalprice(){
        return quantity*item.getBuyprice();
    }
    public void add()throws IOException{
        prFile.addToFile(toString());
    }
    public void edit(Object newData)throws IOException{
        prFile.editFile(toString(), newData.toString());        
    }
    public void remove() throws IOException{
        prFile.removeFromFile(toString());
    }
    public static ArrayList<String[]> view()throws IOException{
        return prFile.viewFile();
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL,String filter) throws IOException{
        return prFile.viewFile(AL,filter);
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL, int attIndex, String filter){
        return prFile.viewFile(AL,attIndex,filter);
    }
    public static String generateID() throws IOException{
        ArrayList<String[]> AL = view();
        if (AL.isEmpty()){
            return "PR001";
        } else{
            for (int i = 0; i<=AL.size();i++){
                String id = "PR";
                String idNo = String.valueOf((i+1));
                
                for (int j = 0; j < (3-idNo.length()); j++){
                    id += "0";
                }
                id += idNo;
                System.out.println(id);
                if (prFile.verifyDataUniqueness(id)){
                    return id;
                }
            }
            return null;
        }
    }
    public boolean verifyUniqueness()throws IOException{
       String[] data = {prID,item.getItemID()};
       int[] i = {0,1};
       return prFile.verifyDataUniqueness(data, i);
    }
    public String toString(){
        return (prID + "|" + item.toStringForPR() + "|" + quantity + "|" + totalprice() + "|" + smID + "|" + status);
    }
    public void approve() throws IOException{
        this.edit(new PurchaseRequisition(this.prID,this.item,this.quantity,this.smID,"Approved"));
        this.status = "Approved";
    }
    public boolean isApproved(){
        return (this.status.matches("Approved"));
    }
    public void reject() throws IOException{
        this.edit(new PurchaseRequisition(this.prID,this.item,this.quantity,this.smID,"Rejected"));
        this.status = "Rejected";
    }
    public boolean isRejected(){
        return (this.status.matches("Rejected"));
    }
   
}       
   
                                                                                                                                                            