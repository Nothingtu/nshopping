package service;

import dao.CommodityDao;
import domain.Commodity;
import util.MySpring;

import java.util.ArrayList;

public class CommodityService {
    private CommodityDao commodityDao = MySpring.getBean("dao.CommodityDao");

    public Commodity selectOneCommodity(String cid){
        return commodityDao.selectOneCommodity(cid);
    }

    public ArrayList<Commodity> selectTypeCommodity(String tid){
         return commodityDao.selectTypeCommodity(tid);
    }
}
