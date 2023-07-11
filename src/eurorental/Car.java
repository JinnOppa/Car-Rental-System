/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eurorental;

/**
 *
 * @author Eugene Winata - TP066869
 */
public class Car {
    private String car_brand;
    private String car_plate;
    private String car_model;
    private int price;
    private String status;

    public Car(String car_brand, String car_plate, String car_model, int price, String status) {
        this.car_brand = car_brand;
        this.car_plate = car_plate;
        this.car_model = car_model;
        this.price = price;
        this.status = status;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
