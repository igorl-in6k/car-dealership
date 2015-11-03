package servlet;

import core.entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/managerinfo")
public class ManagerServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Manager manager = managerService.getManagerById(id);
        req.setAttribute("deals", managerService.getDealsByManager(manager));
        req.setAttribute("manager", manager);
        req.setAttribute("preferredBrandByPrice",
                reportService.getManagerPreferredBrandByPriceAmount(manager));
        req.setAttribute("preferredBrandByDeals",
                reportService.getManagerPreferredBrandByDealsAmount(manager));
        req.getRequestDispatcher("/jsp/managerinfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}