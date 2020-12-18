package service;

import dao.TypeDao;
import domain.Type;
import util.MySpring;

import java.util.ArrayList;

public class TypeService {
    private TypeDao  typeDao = MySpring.getBean("dao.TypeDao");

    public ArrayList<Type> showAllTypes(){
        return typeDao.selectAllType();
    }
}
