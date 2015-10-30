package core.service;

import core.entity.Brand;
import core.entity.Manager;

public interface UtilService {

    Brand getManagerPreferredBrandByDealsAmount(Manager manager);

    Brand getManagerPreferredBrandByPriceAmount(Manager manager);

}
