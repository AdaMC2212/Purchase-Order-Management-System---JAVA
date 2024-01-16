package oodj_assignment;

import java.io.IOException;

public class PurchaseManager extends User{ 
    public PurchaseManager(String userID, String name, String password, String email, String contact){
        super(userID,name,password,email,contact,"PurchaseManager");
    }
    public PurchaseManager(){
        super();
    }
   
   public void approvePR(PurchaseRequisition pr)throws IOException {
        
        pr.approve();
        PurchaseOrder po = new PurchaseOrder(pr,getUserID());
        po.add();

    }
    public void rejectPR(PurchaseRequisition pr)throws IOException{
        pr.reject();
    }
    
    public void removePO(PurchaseOrder po)throws IOException{
        po.remove();
        po.getPR().reject();
    }   
//    public String getRole(){
//        return Role.PurchaseManager.toString();
//    }
}
