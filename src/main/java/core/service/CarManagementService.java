package core.service;

import core.entity.Brand;
import core.entity.Car;
import core.entity.Manager;

import java.util.List;

public interface CarManagementService {

    void addCar(Car newCar);

    void sellCar(Car car, Manager manager);

    List<Car> getCars();

    List<Car> getAvailableCars();

    List<Car> getCarsByBrand(Brand brand);

    Car getCarById(int id);

}
