package core.service.impl;

import core.dao.DealDao;
import core.entity.Car;
import core.entity.Deal;
import core.entity.Manager;
import core.service.DealService;

import java.util.List;

public class DealServiceImpl implements DealService {

    private DealDao dealDao;

    public DealServiceImpl(DealDao dealDao) {
        this.dealDao = dealDao;
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
    public List<Deal> getAllDeals() {
        return dealDao.getAll();
    }

    @Override
    public void removeDeal(Deal deal) {
        dealDao.delete(deal);
    }

    @Override
    public void removeDeal(Car car) {
        dealDao.delete(dealDao.getDealByCar(car));
    }
}
