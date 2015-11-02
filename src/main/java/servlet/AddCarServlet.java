package servlet;

import core.entity.Brand;
import core.entity.Car;
import core.entity.Manager;
import core.service.CarManagementService;
import core.service.StaffManagementService;
import core.service.UtilService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addcar")
public class AddCarServlet extends HttpServlet {

    CarManagementService carService;
    StaffManagementService staffService;
    UtilService utilService;

    @Override
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        carService = context.getBean(CarManagementService.class);
        staffService = context.getBean(StaffManagementService.class);
        utilService = context.getBean(UtilService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brands", utilService.getAllBrands());

        req.getRequestDispatcher("/jsp/addcar.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Brand brand = utilService.getBrandById(Integer.parseInt(req.getParameter("brand_id")));
        String model = req.getParameter("model");
        int price = Integer.parseInt(req.getParameter("price"));
        Car car = new Car(brand, model, price);
        carService.addCar(car);
        req.setAttribute("car", car);
        req.getRequestDispatcher("/jsp/addedcar.jsp").forward(req, resp);
    }
}
