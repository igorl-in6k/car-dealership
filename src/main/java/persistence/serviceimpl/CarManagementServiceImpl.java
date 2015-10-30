package persistence.serviceimpl;

import core.dao.CarDao;
import core.dao.DealDao;
import core.entity.Brand;
import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;
import core.service.CarManagementService;

import java.time.LocalDateTime;
import java.util.List;

public class CarManagementServiceImpl implements CarManagementService {

    private CarDao carDao;
    private DealDao dealDao;

    public CarManagementServiceImpl(CarDao carDao, DealDao dealDao) {
        this.carDao = carDao;
        this.dealDao = dealDao;
    }

    @Override
    public void addCar(Car newCar) {
        carDao.add(newCar);
    }

    @Override
    public void sellCar(Car car, Manager manager) {
        LocalDateTime saleDate = LocalDateTime.now();
        car.setSaleDate(String.format("%d.%d.%d %d:%d",
                                      saleDate.getDayOfMonth(), saleDate.getMonthValue(), saleDate.getYear(),
                                      saleDate.getHour(), saleDate.getMinute()));
        carDao.addOrUpdate(car);
        dealDao.add(new Deal(manager, car));
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

}
