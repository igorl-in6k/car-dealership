package core.service;

import core.entity.Brand;
import core.entity.Manager;

import java.util.List;

public interface ReportService {

    Brand getManagerPreferredBrandByDealsAmount(Manager manager);

    Brand getManagerPreferredBrandByPriceAmount(Manager manager);

}
