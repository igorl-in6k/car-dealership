package core.entity;

import javax.persistence.*;

@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private Manager manager;

    @OneToOne
    @JoinColumn
    private Car car;

    public Deal() {}

    public Deal(Manager manager, Car car) {
        this.manager = manager;
        this.car = car;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public Manager getManager() {
        return manager;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Deal " + id + ": " + car + "; " + manager + ";";
    }
}