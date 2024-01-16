
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;

public class PurchaseOrder {
    private static FileAccess poFile = new FileAccess("po.txt");
    private String pmID;
    private PurchaseRequisition pr;
    
    public PurchaseOrder(PurchaseRequisition pr,String pmID){
        this.pr = pr;
        this.pmID = pmID;
    }
    public PurchaseRequisition getPR(){
        return pr;
    }
    public void add()throws IOException{
        poFile.addToFile(toString());
    }
    public void remove() throws IOException{
        poFile.removeFromFile(toString());
    }
    public static ArrayList<String[]> view()throws IOException{
        return poFile.viewFile();
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL,String filter) throws IOException{
        return poFile.viewFile(AL,filter);
    }
    public static ArrayList<String[]> view(ArrayList<String[]> AL, int attIndex, String filter){
        return poFile.viewFile(AL,attIndex,filter);
    }
    public String toString(){
        return (pr.toString() + "|" + pmID);
    }
    
     
}
