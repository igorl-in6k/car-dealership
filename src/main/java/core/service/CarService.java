package core.service;

import core.entity.Brand;
import core.entity.Car;
import core.entity.Manager;

import java.util.List;

public interface CarService {

    void addCar(Car newCar);

    List<Car> getCars();

    List<Car> getAvailableCars();

    List<Car> getCarsByBrand(Brand brand);

    Car getCarById(int id);

    void removeCar(Car car);

    void editCar(Car car);
}
