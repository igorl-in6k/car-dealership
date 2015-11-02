package servlet;

import core.service.StaffManagementService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deals")
public class DealsServlet extends HttpServlet {

    StaffManagementService service;

    @Override
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        service = context.getBean(StaffManagementService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("deals", service.getAllDeals());
        req.getRequestDispatcher("jsp/deals.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}