package core.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue
    private int id;

    private int price;

    @ManyToOne
    @JoinColumn
    private Brand brand;

    private String model;

    private String saleDate; //todo  local date time

    public Car() {
        saleDate = "";
    }

    public Car(Brand brand, String model, int price) {
        this.price = price;
        this.brand = brand;
        this.model = model;
        saleDate = "";
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSaleDate(String date) {
        this.saleDate = date;
    }

    public String getName() {
        return brand.getName() + " " + model;
    }

    public boolean sold() {
        return !saleDate.equals("");
    }

    @Override
    public String toString() {
        return "(" + id + ") " + brand.getName() + " " + model + "($" + price + ")";
    }
}