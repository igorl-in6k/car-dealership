package persistence.serviceimpl;

import core.dao.CarDao;
import core.entity.Car;
import core.entity.Manager;
import core.service.CarManagementService;

import java.util.List;

public class CarManagementServiceImpl implements CarManagementService {

    private CarDao carDao;

    @Override
    public void addCar(Car newCar) {
        carDao.add(newCar);
    }

    @Override
    public void sellCar(Car car, Manager manager) {

    }

    @Override
    public List<Car> getCars() {
        return carDao.getAll();
    }

    @Override
    public Car getCarById(int id) {
        return carDao.getById(id);
    }

}
