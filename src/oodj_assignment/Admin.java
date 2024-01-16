/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj_assignment;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class Admin extends User {
    public Admin(String userID, String name, String password, String email, String contact) {
        super(userID,name,password,email,contact,"Admin");
        
    }
    public Admin(){
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
    public void addPR(PurchaseRequisition pr)throws IOException{
        pr.setSMID(getUserID());
        pr.add();
    }   
   
    public void editPR(PurchaseRequisition pr, PurchaseRequisition newPR)throws IOException{
        pr.edit(newPR);
        
    }
    public void removePR(PurchaseRequisition pr)throws IOException{
        pr.remove();
    }
    public void addItem(Item item)throws IOException{
        item.add();
    }
    
    public void editItem(Item item, Item newItem)throws IOException{
        item.edit(newItem);
    }
    public void removeItem(Item item)throws IOException{
        item.remove();
    }
    public void addSupplier(Supplier supplier)throws IOException{
        supplier.add();
    }
   
    public void editSupplier(Supplier supplier, Supplier newSupplier)throws IOException{
        supplier.edit(newSupplier);
    }
    public void removeSupplier(Supplier supplier)throws IOException{
        supplier.remove();
    }
    public void addDIS(DailyItemSales DIS)throws IOException {
        if (DIS.getItem().verifyStockAvailability(DIS.getAmountSold())){
            DIS.getItem().reduceStock(DIS.getAmountSold());
            DIS.add();
        } else {
            JOptionPane.showMessageDialog(null, "The Stock is Insufficient");
        }
    }
   
    public void editDIS(DailyItemSales DIS,DailyItemSales newDIS)throws IOException {   
        if (newDIS.getItem().verifyStockAvailability((newDIS.getAmountSold()-DIS.getAmountSold()))){
            DIS.getItem().addStock(DIS.getAmountSold());
            newDIS.getItem().reduceStock(newDIS.getAmountSold());
            DIS.edit(newDIS);
        } else {
            JOptionPane.showMessageDialog(null, "The Stock is Insufficient");
        }      
    }
    public void removeDIS(DailyItemSales DIS)throws IOException {
        DIS.remove();
        DIS.getItem().addStock(DIS.getAmountSold());
    }
    public void addUser(User user)throws IOException{
        user.add();
    }
    //edit everything excluding id
    public void editUser(User user, User newUser)throws IOException{
        user.edit(newUser);
    }
    public void removeUser(User user)throws IOException{
        user.remove();
    }
//    @Override
//    public String getRole(){
//        return Role.Admin.toString();
//    }
}
