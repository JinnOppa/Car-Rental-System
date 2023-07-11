/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eurorental;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eugene Winata - TP066869
 */
public class EURO_CancelBook extends javax.swing.JFrame {

    /**
     * Creates new form EURO_CancelBook
     */
    public EURO_CancelBook() {
        initComponents();
        view();
    }

    final String OLD_FORMAT = "dd/MM/yyyy";
    
    private int findBooking(Customer cust , Car plate, String day, String month, String year, String dayEnd,String monthEnd,String yearEnd,int price,String status){
        for(int i = 0;i<Data.bookingData.size();i++){
            Booking b = Data.bookingData.get(i);
            if(b.getCustomer().getName().equals(cust.getName()) && b.getCar().getCar_plate().equals(plate.getCar_plate()) && b.getDay().equals(day) && b.getMonth().equals(month)&&b.getYear().equals(year)&& b.getPrice() == price && b.getDayEnd().equals(dayEnd) && b.getMonthEnd().equals(monthEnd) && b.getYearEnd().equals(yearEnd)){
                return i;
            }
        }
        return -1;
    }
    
    private int findCar(String car_plate){
        for(int i = 0;i<Data.carData.size();i++){
            Car c = Data.carData.get(i);
            if(c.getCar_plate().equals(car_plate)){
                return i;
            }
        }
        return -1;
    }
    
    private Car queryCar(String car_plate){
        int position = findCar(car_plate);
        if(position>=0){
            return Data.carData.get(position);
        }
        return null;
    }
    
    private Booking queryBook(Customer cust , Car plate, String day, String month,String year,String dayEnd,String monthEnd,String yearEnd,int price, String status){
        int position = findBooking(cust,plate,day,month,year,dayEnd,monthEnd,yearEnd,price,status);
        if(position>=0){
            System.out.print("position " + position);
            return Data.bookingData.get(position);
        }
        return null;
    }
    
    private int findCar(Car car){
        return Data.carData.indexOf(car);
    }
    
    private int findBook(Booking book){
        return Data.bookingData.indexOf(book);
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
        cancelCar = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eurorental/EURO RENTAL.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cancel Booking");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addContainerGap())
        );

        cancelCar.setBackground(new java.awt.Color(204, 204, 204));
        cancelCar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cancelCar.setText("Cancel Booking");
        cancelCar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cancelCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelCarMouseClicked(evt);
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

        bookTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Car Plate", "Start Date", "End Date", "Total Price", "Status", "Card Type", "Card Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Booking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelCar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelCar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnButton)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelCarMouseClicked
        // TODO add your handling code here:
        try{
            if(bookTable.getSelectedRow() == -1)return;
            int number = bookTable.getSelectedRow();
            Customer cust = null;
            Car plate = null;
            for(int i = 0; i<Data.customerData.size();i++){
                if(Data.customerData.get(i).getName().equals(bookTable.getValueAt(number, 0).toString())){
                    cust = Data.customerData.get(i);
                    break;
                }
            }
            for(int i = 0; i<Data.carData.size();i++){
                if(Data.carData.get(i).getCar_plate().equals(bookTable.getValueAt(number, 1).toString())){
                    plate = Data.carData.get(i);
                    break;
                }
            }
            String date = bookTable.getValueAt(number, 2).toString();
            String[] dateDest = date.split("/");
            String day = dateDest[0];
            String month = dateDest[1];
            String year = dateDest[2];
            String dateEnd = bookTable.getValueAt(number, 3).toString();
            String[] dateEndDest = dateEnd.split("/");
            String dayEnd = dateEndDest[0];
            String monthEnd = dateEndDest[1];
            String yearEnd = dateEndDest[2];
            int price = Integer.parseInt(bookTable.getValueAt(number, 4).toString());
            String cardType = bookTable.getValueAt(number, 6).toString();
            String cardNum = bookTable.getValueAt(number, 7).toString();
            String status = "Cancelled";
            int choice;
            if(status.equals("Confirm")){
                choice = 1;
            }else{
                choice = 0;
            }
            Booking modifBook = new Booking(cust,plate,day,month,year,dayEnd,monthEnd,yearEnd,price,status,cardType,cardNum);
            //modify booking
            Booking book = queryBook(cust,plate,day,month,year,dayEnd,monthEnd,yearEnd,price,bookTable.getValueAt(number, 5).toString());
            int foundBook = findBook(book);
            Data.bookingData.set(foundBook, modifBook);
            System.out.println("sucess");
            //modify car status
            if(choice == 1){
                Car modifStatus = new Car(plate.getCar_brand(),plate.getCar_plate(),plate.getCar_model(),plate.getPrice(),"Booked");
                Car car = queryCar(plate.getCar_plate());
                int foundCar = findCar(car);
                Data.carData.set(foundCar,modifStatus);
            }else{
                Car modifStatus = new Car(plate.getCar_brand(),plate.getCar_plate(),plate.getCar_model(),plate.getPrice(),"Available");
                Car car = queryCar(plate.getCar_plate());
                int foundCar = findCar(car);
                Data.carData.set(foundCar,modifStatus);
            }
            Data.write();
            JOptionPane.showMessageDialog(null,"Succesfully Cancel the Book");
            DefaultTableModel table = (DefaultTableModel)bookTable.getModel();
            table.setNumRows(0);
            view();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_cancelCarMouseClicked

    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        // TODO add your handling code here:
        EURO_CustMenu custMenu = new EURO_CustMenu();
        custMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_returnButtonMouseClicked

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
        // TODO add your handling code here:
        int number = bookTable.getSelectedRow();
    }//GEN-LAST:event_bookTableMouseClicked

    public void view(){
        DefaultTableModel table = (DefaultTableModel)bookTable.getModel();
        for(int i = 0; i<Data.bookingData.size();i++){
            if(Data.bookingData.get(i).getCustomer().getName().equals(Data.currentLogin.get(0))){
                String custName = Data.bookingData.get(i).getCustomer().getName();
                String plate = Data.bookingData.get(i).getCar().getCar_plate();
                String startDate = Data.bookingData.get(i).getDay() + "/" + Data.bookingData.get(i).getMonth() + "/" + Data.bookingData.get(i).getYear();
                String endDate = Data.bookingData.get(i).getDayEnd() + "/" + Data.bookingData.get(i).getMonthEnd() + "/" + Data.bookingData.get(i).getYearEnd();
                String price = Integer.toString(Data.bookingData.get(i).getPrice());
                String status = Data.bookingData.get(i).getStatus();
                String cardType = Data.bookingData.get(i).getCardType();
                String cardNumber = Data.bookingData.get(i).getCardNum();
                
                Object[] data = {custName,plate,startDate,endDate,price,status,cardType,cardNumber};
                
                table.addRow(data);
            }
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(EURO_CancelBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EURO_CancelBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EURO_CancelBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EURO_CancelBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EURO_CancelBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookTable;
    private javax.swing.JButton cancelCar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}