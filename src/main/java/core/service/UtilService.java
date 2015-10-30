package core.service;

import core.entity.Brand;
import core.entity.Manager;

public interface UtilService {

    void addBrand(Brand brand);

    Brand getBrandByName(String name);

    Brand getManagerPreferredBrandByDealsAmount(Manager manager);

    Brand getManagerPreferredBrandByPriceAmount(Manager manager);

}
