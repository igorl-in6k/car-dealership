package core.service;

import core.entity.Car;
import core.entity.Manager;

import java.util.List;

public interface CarManagementService {

    void addCar(Car newCar);

    void sellCar(Car car, Manager manager);

    List<Car> getCars();

    Car getCarById(int id);

}
