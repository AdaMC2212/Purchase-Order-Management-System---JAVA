/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package oodj_assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class GUI_Item_Entry extends javax.swing.JFrame {
    
    Admin admin;
    SalesManager sm;
    PurchaseManager pm;
    public GUI_Item_Entry(Admin admin) {
        initComponents();
        this.admin = admin;
        try {
            showTable();
            loadCategory();
            loadSupplier();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Item_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public GUI_Item_Entry(SalesManager sm) {
        initComponents();
        this.sm = sm;
        try {
            showTable();
            loadCategory();
            loadSupplier();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Item_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public GUI_Item_Entry(PurchaseManager pm) {
        initComponents();
        this.pm = pm;
        buttonAdd.setVisible(false);
        buttonEdit.setVisible(false);
        buttonRemove.setVisible(false);
        try {
            showTable();
            loadCategory();
            loadSupplier();
        } catch (IOException ex) {
            Logger.getLogger(GUI_Item_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void showTable() throws IOException {
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
        model.setRowCount(0);
        
        String[] columnNames = { "Item ID","Item Name", "Category", "Stock","Supplier ID","SupplierName","Sell Price","Buy Price"}; 
        model.setColumnIdentifiers(columnNames);
        
        ArrayList<String[]> it = Item.view();
        for (String[] il: it) {
            model.addRow(il);
        }
    }
    public void loadCategory(){
        ItemCategory[] categories = ItemCategory.values();
        DefaultComboBoxModel categoryModel = (DefaultComboBoxModel) cmbCategory.getModel();
        cmbCategory.removeAllItems();
        for (ItemCategory category:categories){
            categoryModel.addElement(category.toString());
        }
        categoryModel.addElement("");
        cmbCategory.setSelectedIndex(-1);
        
    }
    public void loadSupplier()throws IOException{
        ArrayList<String[]> supplierList = Supplier.view();
        DefaultComboBoxModel supplierModel = (DefaultComboBoxModel) cmbSupplier.getModel();
        cmbSupplier.removeAllItems();
        for (String[] supplier: supplierList){
            supplierModel.addElement(supplier[0]+"|"+supplier[1]);
        } 
        supplierModel.addElement("");
        cmbSupplier.setSelectedIndex(-1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAdd = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonSearch = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbCategory = new javax.swing.JComboBox<>();
        cmbSupplier = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAdd.setText("Add item");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit item");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonRemove.setText("Remove item");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Item Entry");

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ItemTable);

        txtSearch.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("PURCHASE ORDER MANAGEMENT SYSTEM");

        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel3.setText("Category:");

        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });

        jLabel4.setText("Supplier:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Back)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(buttonRemove)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonSearch)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(77, 77, 77)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd)
                    .addComponent(buttonEdit)
                    .addComponent(buttonRemove))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearch)
                    .addComponent(jLabel3)
                    .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Back)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        if (admin != null){
            GUI_Add_item add_item = new GUI_Add_item(admin);
            add_item.show();
            this.dispose();
        } else if (sm != null){
            GUI_Add_item add_item = new GUI_Add_item(sm);
            add_item.show();
            this.dispose();
        } 
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed

        int itemRow = ItemTable.getSelectedRow();
        if (itemRow != -1){
            String itemID = ItemTable.getModel().getValueAt(itemRow, 0).toString();
            String itemName = ItemTable.getModel().getValueAt(itemRow, 1).toString();
            String category = ItemTable.getModel().getValueAt(itemRow, 2).toString();
            int stock = Integer.parseInt(ItemTable.getModel().getValueAt(itemRow, 3).toString());
            String supplierID = ItemTable.getModel().getValueAt(itemRow, 4).toString();
            String supplierName = ItemTable.getModel().getValueAt(itemRow, 5).toString();
            double sellPrice = Double.parseDouble(ItemTable.getModel().getValueAt(itemRow, 6).toString());
            double buyPrice = Double.parseDouble(ItemTable.getModel().getValueAt(itemRow, 7).toString());
            Item item = new Item(itemID,itemName,category,stock,supplierID,supplierName,sellPrice,buyPrice);
            System.out.println(item.toString());
            if(admin!=null){
                GUI_Edit_item edit = new GUI_Edit_item(admin,item);
                edit.show();
                this.dispose();
            } else if(sm!=null){
                GUI_Edit_item edit = new GUI_Edit_item(sm,item);
                edit.show();
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(null,"No Item Selected");
        }
    }//GEN-LAST:event_buttonEditActionPerformed
//String itemID, String itemName, String category,int stock, double price, String supplierID,String supplierName
    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
       
        int itemRow = ItemTable.getSelectedRow();
        if (itemRow != -1){
            String itemID = ItemTable.getModel().getValueAt(itemRow, 0).toString();
            String itemName = ItemTable.getModel().getValueAt(itemRow, 1).toString();
            String category = ItemTable.getModel().getValueAt(itemRow, 2).toString();
            int stock = Integer.parseInt(ItemTable.getModel().getValueAt(itemRow, 3).toString());
            String supplierID = ItemTable.getModel().getValueAt(itemRow, 4).toString();
            String supplierName = ItemTable.getModel().getValueAt(itemRow, 5).toString();
            double sellPrice = Double.parseDouble(ItemTable.getModel().getValueAt(itemRow, 6).toString());
            double buyPrice = Double.parseDouble(ItemTable.getModel().getValueAt(itemRow, 7).toString());
            Item item = new Item(itemID,itemName,category,stock,supplierID,supplierName,sellPrice,buyPrice);
            
            try {
                if(admin!=null){
                    admin.removeItem(item);
                    showTable();
                }
                else if(sm!=null){
                    sm.removeItem(item);
                    showTable();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"No Item is Removed.");
            }
        } else {
            JOptionPane.showMessageDialog(null,"No Item is Selected.");
        }
    }//GEN-LAST:event_buttonRemoveActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
        model.setRowCount(0);
        ArrayList<String[]> itemList = new ArrayList<String[]>();
        try {
            itemList = Item.view();
        } catch (IOException ex) {
        }
        while (txtSearch.getText()!= null){
            try {
                itemList = Item.view(itemList,txtSearch.getText());
                break;
            } catch (IOException ex) {
                break;
            }
        } 
        while (cmbCategory.getSelectedIndex() != -1 && cmbCategory.getSelectedItem()!= null && cmbCategory.getSelectedItem().toString().length()>1){
            
            itemList = Item.view(itemList,2,cmbCategory.getSelectedItem().toString());
            break;
        }
        while (cmbSupplier.getSelectedIndex() != -1 && cmbSupplier.getSelectedItem()!= null && cmbSupplier.getSelectedItem().toString().length()>1){
            try {
                itemList = Item.view(itemList,cmbSupplier.getSelectedItem().toString());
                break;
            } catch (IOException ex) {
                break;
            }
        }
        for (String[] line:itemList){
            model.addRow(line);
        }
        
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        if (admin != null){
            GUI_Admin adminHP = new GUI_Admin(admin);
            adminHP.show();
            this.dispose();
        } else if (sm != null){
            GUI_Sales_Manager smHP = new GUI_Sales_Manager(sm);
            smHP.show();
            this.dispose();
        } else if (pm != null){
            GUI_PurchaseManager pmHP = new GUI_PurchaseManager(pm);
            pmHP.show();
            this.dispose();
        }
    }//GEN-LAST:event_BackActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Item_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Item_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Item_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Item_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Item_Entry(new Admin()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTable ItemTable;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
