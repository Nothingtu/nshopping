package controller;

import domain.User;
import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserService service = MySpring.getBean("service.UserService");

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的字符集
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("uname");
        String password = request.getParameter("upassword");
        //将请求中的参数构造成一个User对象
        User user = new User(name,password);
        //调用业务层的方法支持
        String result = service.login(user);
        System.out.println(result);
        //根据业务支持的结果进行展示
        if("登陆成功".equals(result)){
            request.getRequestDispatcher("TypeController").forward(request,response);
        }else{
            request.getSession().setAttribute("result",result);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
