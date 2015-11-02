package servlet;

import core.entity.Car;
import core.entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sellcar")
public class SellCarServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("car", carService.getCarById(Integer.parseInt(req.getParameter("car_id"))));
        req.setAttribute("managers", managerService.getManagers());
        req.getRequestDispatcher("jsp/sellcar.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = carService.getCarById(Integer.parseInt(req.getParameter("car_id")));
        Manager manager = managerService.getManagerById(
                Integer.parseInt(req.getParameter("manager_id")));
        if ( !car.sold() ) {
            carService.sellCar(car, manager);
            req.setAttribute("car", car);
            req.setAttribute("manager", manager);
            req.getRequestDispatcher("jsp/soldcar.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("jsp/alreadysold.jsp").forward(req,resp);
        }
    }
}