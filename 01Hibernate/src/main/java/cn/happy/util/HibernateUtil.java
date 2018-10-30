package cn.happy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Happy on 2017-12-26.
 */
public class HibernateUtil {
    //线程变量  get  set
    static ThreadLocal<Session> tlSession=new ThreadLocal<Session>();
    //得有SessionFactory
    public static SessionFactory factory;
    static Configuration cfg=null;
    static {
        cfg=new Configuration().configure("hibernate.cfg.xml");
        factory=cfg.buildSessionFactory();
    }

    //01.获取连接
    public static Session getSession(){
        //01.从线程变量中尝试获取
        Session session = tlSession.get();
        if (session==null){
            //用户第一次获取连接：发现线程变量中没有session，创建一个，并且放入线程变量
            session = factory.openSession();
            tlSession.set(session);
        }
        return session;
    }

    //02.释放连接
    public static void closeSession(){
        Session session = tlSession.get();
        if (session!=null){
            //线程变量set成null
            tlSession.set(null);
            session.close();
        }
    }



}
