package controller;

import core.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected ManagerService managerService;
    @Autowired
    protected CarService carService;
    @Autowired
    protected BrandService brandService;
    @Autowired
    protected ReportService reportService;
    @Autowired
    protected DealService dealService;
}
