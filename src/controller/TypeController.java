package controller;

import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
import service.TypeService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TypeController extends HttpServlet {
    private TypeService typeService = MySpring.getBean("service.TypeService");

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getSession().setAttribute("allType",typeService.showAllTypes());
        request.getRequestDispatcher("showAllType.jsp").forward(request,response);
    }
}
