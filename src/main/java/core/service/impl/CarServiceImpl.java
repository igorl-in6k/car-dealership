package core.service.impl;

import core.dao.CarDao;
import core.dao.DealDao;
import core.entity.Brand;
import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;
import core.service.CarService;

import java.time.LocalDateTime;
import java.util.List;

public class CarServiceImpl implements CarService {

    private CarDao carDao;
    private DealDao dealDao;

    public CarServiceImpl(CarDao carDao, DealDao dealDao) {
        this.carDao = carDao;
        this.dealDao = dealDao;
    }

    @Override
    public void addCar(Car newCar) {
        carDao.add(newCar);
    }


    @Override
    public List<Car> getCars() {
        return carDao.getAll();
    }

    @Override
    public List<Car> getAvailableCars() {
        return carDao.getAvailableCars();
    }

    @Override
    public List<Car> getCarsByBrand(Brand brand) {
        return carDao.getCarsByBrand(brand);
    }

    @Override
    public Car getCarById(int id) {
        return carDao.getById(id);
    }

    @Override
    public void removeCar(Car car) {
        carDao.delete(car);
    }

    @Override
    public void editCar(Car car) {
        carDao.update(car);
    }

}
