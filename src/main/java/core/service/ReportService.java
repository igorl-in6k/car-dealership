package core.service;

import core.entity.Brand;
import core.entity.Manager;

public interface ReportService {

    Brand getManagerPreferredBrandByDealsAmount(Manager manager);

    Brand getManagerPreferredBrandByPriceAmount(Manager manager);

}
