package service;

import dao.UserDao;
import domain.User;
import util.MySpring;

public class UserService {
    private UserDao userDao = MySpring.getBean("dao.UserDao");
    public String  login(User user){
        User realUser = userDao.selectOne(user.getUname());
        if(realUser!=null && realUser.getUpassword().equals(user.getUpassword())){//证明根据给定的用户名查到了相应的个人信息
                return "登陆成功";
        }
        return "用户名或密码错误";
    }
}
