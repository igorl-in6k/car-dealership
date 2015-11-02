package servlet;

import core.entity.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addmanager")
public class AddManagerServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addmanager.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Manager manager = parseManager(req);
        managerService.addManager(manager);
        req.setAttribute("manager", manager);
        req.getRequestDispatcher("/jsp/addedmanager.jsp").forward(req, resp);
    }
}
