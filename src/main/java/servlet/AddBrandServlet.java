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

@WebServlet(urlPatterns = "/addbrand")
public class AddBrandServlet extends HttpServlet {

    UtilService utilService;

    @Override
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        utilService = context.getBean(UtilService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addbrand.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandName = req.getParameter("name");
        Brand brand = new Brand(brandName);
        utilService.addBrand(brand);
        req.setAttribute("brand", brand);
        req.getRequestDispatcher("jsp/addedbrand.jsp").forward(req, resp);
    }
}
