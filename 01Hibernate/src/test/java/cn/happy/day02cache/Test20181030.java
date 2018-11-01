package cn.happy.day02cache;/**
 * Created by Happy on 2018-10-29.
 */

import cn.happy.entity.Dept;
import cn.happy.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * 作者：微冷的雨
 *
 * @create 2018-10-29
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class Test20181030 {

    //关于一些系统级别的路径的测试
    @Test
    public void t7(){
        System.out.println(System.getProperty("java.io.tmpdir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("user.dir"));
    }

    //二级缓存存在性的证明
    @Test
    public void t6() {
        Session session= HibernateUtil.getSession();
        Dept dept = session.load(Dept.class, 1);
        System.out.println(dept.getDeptname());
        HibernateUtil.closeSession();
        System.out.println("=============================");
        Session session2= HibernateUtil.getSession();
        Dept dept2 = session2.load(Dept.class, 1);
        System.out.println(dept2.getDeptname());
        HibernateUtil.closeSession();
    }

    //3.证明iterator()  N+1
    @Test
    public void t5(){
        Session session= HibernateUtil.getSession();
        String hql="from Dept";
        Query query = session.createQuery(hql);
        //iterrable
        //Enumerable

        Iterator<Dept> iterate = query.iterate();
        while (iterate.hasNext()){
            Dept dept = iterate.next();
            System.out.println(dept.getDeptname());
        }
        System.out.println("======================");
        HibernateUtil.closeSession();
    }


    //3.证明list只可以将数据放入一缓，但是不能从一级缓存获取数据
    @Test
    public void t4(){
        Session session= HibernateUtil.getSession();
        String hql="from Dept";
        Query query = session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept dept:list) {
            System.out.println(dept.getDeptname());
        }
      /*  System.out.println("======================");
        //泛型迭代器
        Iterator<Dept> iterate = query.iterate();
       while (iterate.hasNext()){
            Dept dept = iterate.next();
            System.out.println(dept.getDeptname());
        }*/
      /*  Dept dept = session.load(Dept.class, 1);
        System.out.println(dept.getDeptname());*/
        /*List<Dept> list2=query.list();
        for (Dept dept:list2) {
            System.out.println(dept.getDeptname());
        }*/
        HibernateUtil.closeSession();
    }


    //证明一级缓存是不能跨Session
    @Test
    public void t2() {
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Dept dept = session.load(Dept.class,1);
        System.out.println(dept.getDeptname());
        tx.commit();
        HibernateUtil.closeSession();

        System.out.println("==================");
        Session session2 = HibernateUtil.getSession();
        Transaction tx2=session2.beginTransaction();
        Dept dept2=session2.get(Dept.class,1);
        System.out.println(dept2.getDeptname());
        tx2.commit();
        HibernateUtil.closeSession();
    }

    @Test
    //1.印记     一级缓存存在的
    public void t1(){
        //1.ThreadLocal
        Session session = HibernateUtil.getSession();

        Transaction tx=session.beginTransaction();
        Dept dept = session.load(Dept.class,1);
        System.out.println(dept.getDeptname());

        System.out.println("==================");
        Dept dept2=session.get(Dept.class,1);
        System.out.println(dept2.getDeptname());
        tx.commit();
        HibernateUtil.closeSession();
    }
}
