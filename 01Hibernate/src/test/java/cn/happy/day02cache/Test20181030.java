package cn.happy.day02cache;/**
 * Created by Happy on 2018-10-29.
 */

import cn.happy.entity.Dept;
import cn.happy.util.HibernateUtil;
import org.hibernate.Criteria;
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

    //3.证明iterator  N+1
    @Test
    public void t5(){
        Session session= HibernateUtil.getSession();
        String hql="from Dept";
        Query query = session.createQuery(hql);
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
        System.out.println("======================");

        /* Iterator<Dept> iterate = query.iterate();
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
    //1.检索所有的部门集合
    public void t1(){
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
