package controller;

import domain.Commodity;
import service.CommodityService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 转发forward的请求方式和上一次请求的方式是一致的
 */
public class ShoppingCarController extends HttpServlet {
    private CommodityService commodityService= MySpring.getBean("service.CommodityService");
    //ArrayList集合用来存储选择的商品
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        float sumPrice =0;
        String hidden = request.getParameter("flag");
        String[] cidValues = request.getParameterValues("result");
        //ArrayList集合用来存储选择的商品 为了保证购买的商品在多个请求是不丢失 必须将其存储起来
        //commodityList的管理类是生命周期托管
        HttpSession session= request.getSession();
        ArrayList<Commodity> commodityList =(ArrayList<Commodity>)session.getAttribute("shoppingCar");
        if(commodityList==null){
            commodityList =new ArrayList<Commodity>();
        }
        for(String cid:cidValues){
            Commodity commodity = commodityService.selectOneCommodity(cid);
            commodityList.add(commodity);
            sumPrice += commodity.getCprice();
        }
        session.setAttribute("shoppingCar",commodityList);
        session.setAttribute("sumPrice",sumPrice);
        if("继续购物".equals(hidden)){
            request.getRequestDispatcher("showAllType.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("settlement.jsp").forward(request,response);
        }
    }
}
