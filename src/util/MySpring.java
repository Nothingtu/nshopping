package util;

import java.util.HashMap;

/**
 * 设计一个工具用来管理对象的创建
 */
public class MySpring {
    //创建集合属性 用来存储创建过得对象
    private static HashMap<String,Object> beanMap = new HashMap<>();

    //设计一个方法 用来创建对象
    public static  <T>T getBean(String className){
        Object obj= beanMap.get(className);
        if(obj==null){
            try {
                obj = Class.forName(className).getConstructor().newInstance();
                beanMap.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (T)obj;
    }

}
