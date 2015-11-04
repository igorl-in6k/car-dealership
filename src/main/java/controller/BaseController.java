package controller;

import core.service.BrandService;
import core.service.CarManagementService;
import core.service.ReportService;
import core.service.StaffManagementService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected StaffManagementService managerService;
    @Autowired
    protected CarManagementService carService;
    @Autowired
    protected BrandService brandService;
    @Autowired
    protected ReportService reportService;
}
