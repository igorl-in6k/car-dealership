package servlet;

import core.entity.Brand;
import core.entity.Car;
import core.entity.Manager;
import core.service.BrandService;
import core.service.CarManagementService;
import core.service.ReportService;
import core.service.StaffManagementService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public abstract class BaseServlet extends HttpServlet {

    protected CarManagementService carService;
    protected StaffManagementService managerService;
    protected BrandService brandService;
    protected ReportService reportService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        carService = context.getBean(CarManagementService.class);
        managerService = context.getBean(StaffManagementService.class);
        brandService = context.getBean(BrandService.class);
        reportService = context.getBean(ReportService.class);
    }

    public Manager parseManager(HttpServletRequest req) {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        return new  Manager(name, age);
    }

    public Car parseCar(HttpServletRequest req) {
        Brand brand = brandService.getBrandById(Integer.parseInt(req.getParameter("brand_id")));
        String model = req.getParameter("model");
        int price = Integer.parseInt(req.getParameter("price"));
        return new Car(brand, model, price);
    }
}
