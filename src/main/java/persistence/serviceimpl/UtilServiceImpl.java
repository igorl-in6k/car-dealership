package persistence.serviceimpl;

import core.dao.BrandDao;
import core.dao.CarDao;
import core.dao.DealDao;
import core.dao.ManagerDao;
import core.entity.Brand;
import core.entity.Deal;
import core.entity.Manager;
import core.service.UtilService;

import java.util.HashMap;
import java.util.Map;

public class UtilServiceImpl implements UtilService {

    private CarDao carDao;
    private ManagerDao managerDao;
    private DealDao dealDao;
    private BrandDao brandDao;

    public UtilServiceImpl(CarDao carDao, ManagerDao managerDao, DealDao dealDao, BrandDao brandDao) {
        this.carDao = carDao;
        this.managerDao = managerDao;
        this.dealDao = dealDao;
        this.brandDao = brandDao;
    }

    @Override
    public void addBrand(Brand brand) {
        brandDao.add(brand);
    }

    @Override
    public Brand getBrandByName(String name) {
        return brandDao.getByName(name);
    }

    @Override
    public Brand getManagerPreferredBrandByDealsAmount(Manager manager) {
        Map<Brand, Integer> brandsAndPrices = new HashMap<>();
        int maxPrice = 0;
        Brand preferredBrand = new Brand();
        for (Deal deal : dealDao.getDealsByManager(manager)) {
            Brand currentDealCarBrand = deal.getCar().getBrand();
            int currentDealCarPrice = deal.getCar().getPrice();
            if (brandsAndPrices.containsKey(currentDealCarBrand)) {
                currentDealCarPrice += brandsAndPrices.get(currentDealCarBrand);
            }
            brandsAndPrices.put(currentDealCarBrand, currentDealCarPrice);
            if ( currentDealCarPrice > maxPrice ) {
                preferredBrand = currentDealCarBrand;
                maxPrice = currentDealCarPrice;
            }
        }
        return preferredBrand;
    }

    @Override
    public Brand getManagerPreferredBrandByPriceAmount(Manager manager) {
        Map<Brand, Integer> brandsAndCounts = new HashMap<>();
        int max = 0;
        Brand maxBrand = new Brand();
        for (Deal deal : dealDao.getDealsByManager(manager)) {
            Brand brand = deal.getCar().getBrand();
            int count = 0;
            if ( brandsAndCounts.containsKey(brand) ) {
                count = brandsAndCounts.get(brand);
            }
            if ( ++count > max ) {
                max = count;
                maxBrand = brand;
            }
            brandsAndCounts.put(brand, count);
        }
        return maxBrand;
    }

}
