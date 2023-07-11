package eurorental;

import eurorental.Booking;
import eurorental.Car;
import eurorental.Customer;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Eugene Winata - TP066869
 */
public class Data {
    public static ArrayList<Customer>customerData = new ArrayList<Customer>();
    public static ArrayList<Car>carData = new ArrayList<Car>();
    public static ArrayList<Booking>bookingData = new ArrayList<Booking>();
    public static ArrayList<String>currentLogin = new ArrayList<String>();
//    final String OLD_FORMAT = "dd/MM/yyyy";
    
    public static void check(){
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            //DateFormat sdf1 = DateFormat.getDateInstance();
            Date dateConvert = new Date();
            String dateConvertString = sdf.format(dateConvert);
            Date newdate = sdf.parse(dateConvertString);
//        DefaultTableModel table = (DefaultTableModel)carTable.getModel();
        for(int j = 0;j<Data.bookingData.size();j++){
            String dateBooked = Data.bookingData.get(j).getDay() + "/" + Data.bookingData.get(j).getMonth() + "/" + Data.bookingData.get(j).getYear();
            Date dateBook = sdf.parse(dateBooked);
            String dateEnd = Data.bookingData.get(j).getDayEnd() + "/" + Data.bookingData.get(j).getMonthEnd() + "/" + Data.bookingData.get(j).getYearEnd();
            Date dateBookEnd = sdf.parse(dateEnd);
            if(dateBook.compareTo(dateConvert)<0 && dateBookEnd.compareTo(dateConvert)>0 && Data.bookingData.get(j).getStatus().equals("Confirm")){
                for(int i =0;i<Data.carData.size();i++){
                   if(Data.bookingData.get(j).getCar().getCar_plate().equals(Data.carData.get(i).getCar_plate())&& newdate.compareTo(dateBook)<=0 && newdate.compareTo(dateBookEnd)>0){
                       System.out.println(dateBook.compareTo(dateConvert)<0);
                        Data.carData.get(i).setStatus("Booked");
                        Data.write();
                   }
                }
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void read(){
        try{
            System.out.println("Customer load");
            Scanner sCust = new Scanner(new File("Customer.txt"));
            while(sCust.hasNext()){
                String[] customer;
                String data = sCust.nextLine();
                customer = data.split(" ");
                String username = customer[0];
                String password = customer[1];
                String name = customer[2];
                String phone_number = customer[3];
                String location = customer[4];
                Customer custData = new Customer(username,password,name,phone_number,location);
                customerData.add(custData);
            }
            Scanner sCar = new Scanner(new File("Car.txt"));
            while(sCar.hasNext()){
                String[] car;
                String data = sCar.nextLine();
                car = data.split(" ");
                String car_brand = car[0];
                String car_plate = car[1];
                String car_model = car[2];
                int price = Integer.parseInt(car[3]);
                String status = car[4];
                Car carDataNew = new Car(car_brand, car_plate, car_model, price, status);
                carData.add(carDataNew);
            }
            Scanner sBook = new Scanner(new File("Booking.txt"));
            while(sBook.hasNext()){
                String[] book;
                String[] dateBook;
                String[] dateEnd;
                String data = sBook.nextLine();
                book = data.split(" ");
                Customer customerName = Data.checkCust(book[0]);
                Car carPlate = Data.checkCar(book[1]);
                dateBook = book[2].split("/");
                String day = dateBook[0];
                String month = dateBook[1];
                String year = dateBook[2];
                dateEnd = book[3].split("/");
                String dayEnd = dateEnd[0];
                String monthEnd = dateEnd[1];
                String yearEnd = dateEnd[2];
                int price = Integer.parseInt(book[4]);
                String status = book[5];
                String cardType = book[6];
                String cardNum = book[7];
                Booking newBooking = new Booking(customerName,carPlate,day,month,year,dayEnd,monthEnd,yearEnd,price,status,cardType,cardNum);
                bookingData.add(newBooking);
            }
            check();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Customer checkCust(String name){
        for(Customer cust : customerData){
            if(name.equals(cust.getName())){
                return cust;
            }
        }
        return null;
    }
    
    public static Car checkCar(String plate){
        for(Car carPlate : carData){
            if(plate.equals(carPlate.getCar_plate())){
                return carPlate;
            }
        }
        return null;
    }
    
    public static void insert(String name){
        currentLogin.add("");
        currentLogin.set(0, name);
    }
    
    public static void reset(){
        currentLogin.set(0,"");
    }
    
    
    public static void write(){
        try{
            PrintWriter customer = new PrintWriter("Customer.txt");
            for(int i = 0; i<customerData.size();i++){
                customer.println(customerData.get(i).getUsername() + " " + customerData.get(i).getPassword() + " " 
                        + customerData.get(i).getName() + " " + customerData.get(i).getPhone_number() + " " 
                        + customerData.get(i).getLocation());
            }
            customer.close();
            PrintWriter car = new PrintWriter("Car.txt");
            for(int i = 0; i<carData.size();i++){
                car.println(carData.get(i).getCar_brand() + " " + carData.get(i).getCar_plate() + " " 
                        + carData.get(i).getCar_model() + " " + carData.get(i).getPrice() + " " 
                        + carData.get(i).getStatus());
            }
            car.close();
            PrintWriter booking = new PrintWriter("Booking.txt");
            for(int i =0; i<bookingData.size();i++){
                booking.println(bookingData.get(i).getCustomer().getName() + " " 
                        + bookingData.get(i).getCar().getCar_plate() + " " + bookingData.get(i).getDay() + "/" 
                        + bookingData.get(i).getMonth() + "/" + bookingData.get(i).getYear() + " " 
                        + bookingData.get(i).getDayEnd() + "/" + bookingData.get(i).getMonthEnd() + "/" 
                        + bookingData.get(i).getYearEnd() + " " + bookingData.get(i).getPrice() + " " 
                        + bookingData.get(i).getStatus() + " " + bookingData.get(i).getCardType() + " " 
                        + bookingData.get(i).getCardNum());            }
            booking.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
    

