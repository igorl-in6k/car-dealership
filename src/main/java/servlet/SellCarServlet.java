package servlet;

import core.entity.Car;
import core.entity.Manager;
import core.service.CarManagementService;
import core.service.StaffManagementService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sellcar")
public class SellCarServlet extends HttpServlet {

    CarManagementService carService;
    StaffManagementService staffService;

    @Override
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        carService = context.getBean(CarManagementService.class);
        staffService = context.getBean(StaffManagementService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ( req.getParameter("car_id") == null ) {
            req.setAttribute("cars", carService.getAvailableCars());
        }
        if ( req.getParameter("manager_id") == null ) {
            req.setAttribute("managers", staffService.getManagers());
        }

        req.getRequestDispatcher("jsp/sellcar.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = carService.getCarById(Integer.parseInt(req.getParameter("car_id")));
        Manager manager = staffService.getManagerById(Integer.parseInt(req.getParameter("manager_id")));
        if ( !car.sold() ) {
            carService.sellCar(car, manager);
            req.setAttribute("car", car);
            req.setAttribute("manager", manager);
            req.getRequestDispatcher("jsp/soldcar.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("jsp/alreadysold").forward(req,resp);
        }

    }
}