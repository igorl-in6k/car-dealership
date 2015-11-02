package servlet;

import core.entity.Manager;
import core.service.CarManagementService;
import core.service.StaffManagementService;
import core.service.ReportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addmanager")
public class AddManagerServlet extends HttpServlet {

    CarManagementService carService;
    StaffManagementService staffService;
    ReportService utilService;

    @Override
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        carService = context.getBean(CarManagementService.class);
        staffService = context.getBean(StaffManagementService.class);
        utilService = context.getBean(ReportService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addmanager.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Manager manager = new  Manager(name, age);
        staffService.addManager(manager);
        req.setAttribute("manager", manager);
        req.getRequestDispatcher("/jsp/addedmanager.jsp").forward(req, resp);
    }
}
