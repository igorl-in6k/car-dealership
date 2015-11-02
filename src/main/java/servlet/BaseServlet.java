package servlet;

import core.service.BrandService;
import core.service.CarManagementService;
import core.service.ReportService;
import core.service.StaffManagementService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    protected CarManagementService carService;
    protected StaffManagementService staffService;
    protected BrandService brandService;
    protected ReportService reportService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        carService = context.getBean(CarManagementService.class);
        staffService = context.getBean(StaffManagementService.class);
        brandService = context.getBean(BrandService.class);
        reportService = context.getBean(ReportService.class);
    }
}
