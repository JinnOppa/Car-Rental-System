/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eurorental;

/**
 *
 * @author Eugene Winata - TP066869
 */
public class EURORental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EURO_Login login = new EURO_Login();
        login.setVisible(true);
        Data.read();
    }
    
}
