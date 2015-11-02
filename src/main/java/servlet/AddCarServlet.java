package servlet;


import core.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addcar")
public class AddCarServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("brands", brandService.getAllBrands());
        req.getRequestDispatcher("/jsp/addcar.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Car car = parseCar(req);
        carService.addCar(car);
        req.setAttribute("car", car);
        req.getRequestDispatcher("/jsp/addedcar.jsp").forward(req, resp);
    }
}
