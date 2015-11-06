package core.service.impl;

import core.dao.CarDao;
import core.dao.DealDao;
import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;
import core.service.DealService;

import java.time.LocalDateTime;
import java.util.List;

public class DealServiceImpl implements DealService {

    private DealDao dealDao;
    private CarDao carDao;

    public DealServiceImpl(DealDao dealDao, CarDao carDao) {
        this.dealDao = dealDao;
        this.carDao = carDao;
    }

    @Override
    public List<Deal> getDealsByManager(Manager manager) {
        return dealDao.getDealsByManager(manager);
    }

    @Override
    public Deal getDealByCar(Car car) {
        return dealDao.getDealByCar(car);
    }

    @Override
    public Deal getDealById(int id) {
        return dealDao.getById(id);
    }

    @Override
    public List<Deal> getAllDeals() {
        return dealDao.getAll();
    }

    @Override
    public void removeDeal(Deal deal) {
        dealDao.delete(deal);
    }

    @Override
    public void removeDeal(Car car) {
        if ( car != null )
            dealDao.delete(dealDao.getDealByCar(car));
    }

    @Override
    public void removeDeals(Manager manager) {
        for (Deal deal : getDealsByManager(manager)) {
            removeDeal(deal);
        }
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
}
