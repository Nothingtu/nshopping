package controller;

import domain.Commodity;
import service.CommodityService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CommodityController extends HttpServlet {
    private CommodityService commodityService= MySpring.getBean("service.CommodityService");
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tid = request.getParameter("tid");
        System.out.println(tid);
        ArrayList<Commodity> commodityList = commodityService.selectTypeCommodity(tid);
        request.setAttribute("commodityList",commodityList);
        request.getRequestDispatcher("commodity.jsp").forward(request,response);
    }
}
