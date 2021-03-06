package core.service.impl;

import core.dao.DealDao;
import core.entity.Brand;
import core.entity.Deal;
import core.entity.Manager;
import core.service.ReportService;

import java.util.HashMap;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    private DealDao dealDao;

    public ReportServiceImpl(DealDao dealDao) {
        this.dealDao = dealDao;
    }

    @Override
    public Brand getManagerPreferredBrandByPriceAmount(Manager manager) {
        Map<Brand, Integer> brandsAndPrices = new HashMap<>();
        int maxPrice = 0;
        Brand preferredBrand = new Brand();
        for (Deal deal : dealDao.getDealsByManager(manager)) {
            Brand currentDealBrand = deal.getCarBrand();
            int currentDealPrice = deal.getCarPrice();
            if (brandsAndPrices.containsKey(currentDealBrand)) {
                currentDealPrice += brandsAndPrices.get(currentDealBrand);
            }
            brandsAndPrices.put(currentDealBrand, currentDealPrice);
            if ( currentDealPrice > maxPrice ) {
                preferredBrand = currentDealBrand;
                maxPrice = currentDealPrice;
            }
        }
        return preferredBrand;
    }

    @Override
    public Brand getManagerPreferredBrandByDealsAmount(Manager manager) {
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
