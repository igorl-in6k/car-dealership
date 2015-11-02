package servlet;

import core.entity.Manager;
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

@WebServlet(urlPatterns = "/managerinfo")
public class ManagerServlet extends HttpServlet {

    StaffManagementService service;
    ReportService utilService;

    @Override
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        service = context.getBean(StaffManagementService.class);
        utilService = context.getBean(ReportService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Manager manager = service.getManagerById(id);
        req.setAttribute("deals", service.getDealsByManager(manager));
        req.setAttribute("manager", manager);
        req.setAttribute("preferredBrandByPrice", utilService.getManagerPreferredBrandByPriceAmount(manager));
        req.setAttribute("preferredBrandByDeals", utilService.getManagerPreferredBrandByDealsAmount(manager));
        req.getRequestDispatcher("/jsp/managerinfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}