package core.service;

import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;

import java.util.List;

public interface DealService {

    List<Deal> getDealsByManager(Manager manager);

    Deal getDealByCar(Car car);

    List<Deal> getAllDeals();

    void removeDeal(Deal deal);

    void removeDeal(Car car);

    void removeDeals(Manager manager);

    void sellCar(Car car, Manager manager);
}
