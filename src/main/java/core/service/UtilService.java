package core.service;

import core.entity.Brand;
import core.entity.Manager;

import java.util.List;

public interface UtilService {

    void addBrand(Brand brand);

    Brand getBrandByName(String name);

    Brand getBrandById(int id);

    List<Brand> getAllBrands();

    Brand getManagerPreferredBrandByDealsAmount(Manager manager);

    Brand getManagerPreferredBrandByPriceAmount(Manager manager);

}
