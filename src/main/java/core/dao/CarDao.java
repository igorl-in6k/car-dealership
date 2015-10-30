package core.dao;

import core.entity.Brand;
import core.entity.Car;

import java.util.List;

public interface CarDao extends BaseDao<Car> {

    List<Car> getAvailableCars();

    List<Car> getCarsByBrand(Brand brand);
}