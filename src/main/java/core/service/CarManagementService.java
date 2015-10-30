package core.service;

import core.entity.Brand;
import core.entity.Car;

import java.util.List;

public interface CarManagementService {

    void addCar(Car newCar);

    void sellCar(int carId, int managerId);

    List<Car> getCars();

    Car getCarById(int id);

    List<Car> getCarsByBrand(Brand brand);


}
