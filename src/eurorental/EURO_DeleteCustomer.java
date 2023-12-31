/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eurorental;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eugene Winata - TP066869
 */
public class EURO_DeleteCustomer extends javax.swing.JFrame {

    /**
     * Creates new form EURO_DeleteCustomer
     */
    public EURO_DeleteCustomer() {
        initComponents();
        view();
    }

    private int findCust(String username, String password, String name, String phoneNumber, String location){
        for(int i = 0;i<Data.customerData.size();i++){
            Customer c = Data.customerData.get(i);
            if(c.getUsername().equals(username) && c.getPassword().equals(password) && c.getName().equals(name) && c.getPhone_number().equals(phoneNumber) && c.getLocation().equals(location)){
                return i;
            }
        }
        return -1;
    }
    
    private Customer queryCust(String username, String password, String name, String phoneNumber, String location){
        int position = findCust(username,password,name,phoneNumber,location);
        if(position>0){
            return Data.customerData.get(position);
        }
        return null;
    }
    
    private int findCust(Customer cust){
        return Data.customerData.indexOf(cust);
    }
    
    public void view(){
        DefaultTableModel custTable = (DefaultTableModel)custList.getModel(); 
        for(int i = 0; i<Data.customerData.size();i++){
            String name = Data.customerData.get(i).getName();
            String username = Data.customerData.get(i).getUsername();
            String phone = Data.customerData.get(i).getPhone_number();
            String password = Data.customerData.get(i).getPassword();
            String location = Data.customerData.get(i).getLocation();
            
            Object[] data = {username,password,name,phone,location};
            custTable.addRow(data);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        deleteCustomer = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        custList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eurorental/EURO RENTAL.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Delete Customer");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addContainerGap())
        );

        deleteCustomer.setBackground(new java.awt.Color(204, 204, 204));
        deleteCustomer.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        deleteCustomer.setText("Delete Customer");
        deleteCustomer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        deleteCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCustomerMouseClicked(evt);
            }
        });

        returnButton.setBackground(new java.awt.Color(204, 204, 204));
        returnButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        returnButton.setText("Return");
        returnButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Customers List");

        custList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        custList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Name", "Phone Number", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        custList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(custList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton)
                    .addComponent(deleteCustomer))
                .addGap(0, 89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void custListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_custListMouseClicked

    private void deleteCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCustomerMouseClicked
        // TODO add your handling code here:
//        if(custList.getSelectedRow() == -1)return;
//        if(custList.getSelectedRow() == 0){
//            Data.customerData.remove(0);
//            Data.write();
//            DefaultTableModel table = (DefaultTableModel)custList.getModel();
//            table.setNumRows(0);
//            view();
//            return;   
//        }
//        int number = custList.getSelectedRow();
//            String username = custList.getValueAt(number, 0).toString();
//            String password = custList.getValueAt(number, 1).toString();
//            String name = custList.getValueAt(number, 2).toString();
//            String phoneNumber = custList.getValueAt(number, 3).toString();
//            String location = custList.getValueAt(number, 4).toString();
//
//            Customer delCust = queryCust(username,password,name,phoneNumber,location);
//            int found = findCust(delCust);
//            Data.customerData.remove(found);
//            Data.write();
//            DefaultTableModel table = (DefaultTableModel)custList.getModel();
//            table.setNumRows(0);
            try{
        if(custList.getSelectedRow()== -1)return;
        if(custList.getSelectedRow()== 0){
        int number = custList.getSelectedRow();
        Data.customerData.remove(0);
        Data.write();
        DefaultTableModel table = (DefaultTableModel)custList.getModel();
        table.setNumRows(0);
        view();
        return;
        }
        int number = custList.getSelectedRow();
        String username = custList.getValueAt(number, 0).toString();
        String password = custList.getValueAt(number, 1).toString();
        String name = custList.getValueAt(number, 2).toString();
        String phone = custList.getValueAt(number, 3).toString();
        String location = custList.getValueAt(number, 4).toString();
        
        Customer delCustomer = queryCust(username,password,name,phone,location);
        int found = findCust(delCustomer);
        Data.customerData.remove(found);
        Data.write();
        JOptionPane.showMessageDialog(null,"Succesfully Delete");
        DefaultTableModel table = (DefaultTableModel)custList.getModel();
        table.setNumRows(0);
        view();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Delete Failed"); 
            e.printStackTrace();
        }
            
    }//GEN-LAST:event_deleteCustomerMouseClicked

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        // TODO add your handling code here:
        EURO_AdmMenu admMenu = new EURO_AdmMenu();
        admMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButtonMouseClicked

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
            java.util.logging.Logger.getLogger(EURO_DeleteCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EURO_DeleteCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EURO_DeleteCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EURO_DeleteCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Data.read();
                new EURO_DeleteCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable custList;
    private javax.swing.JButton deleteCustomer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}
