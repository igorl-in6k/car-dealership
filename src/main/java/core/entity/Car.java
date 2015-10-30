package core.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "id")
    private Brand brand;

    @Column(name = "model")
    private String model;

    public Car() {}

    public Car(Brand brand, String model, int price) {
        this.price = price;
        this.brand = brand;
        this.model = model;
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

    @Override
    public String toString() {
        return "Car " + id + ": " + brand + " " + model + "($" + price + ")";
    }
}