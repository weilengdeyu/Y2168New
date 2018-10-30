package cn.happy.day01;/**
 * Created by Happy on 2018-10-25.
 */

import cn.happy.entity.Dept;
import cn.happy.entity.Emp;
import cn.happy.util.EmpCondition;
import cn.happy.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：微冷的雨
 *
 * @create 2018-10-25
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class Test20181027 {

    /**
     * 1.11  DetachedCriteria和Criteria功能类似，它实现了CriteriaSpecification接口
     Criteria是由Session对象创建的
     DetachedCriteria创建时不需要Session对象
     使用DetachedCriteria来构造查询条件
     可以把DetachedCriteria作为方法参数传递给业务层
     * 查询开发部的员工
     * */
    @Test
    public void detachedCriteriaTest(){
        Session session = HibernateUtil.getSession();
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Emp.class);
        detachedCriteria.createAlias("dept", "d");
        detachedCriteria.add(Restrictions.eq("d.deptname", "开发部"));
        List<Emp> list =detachedCriteria.getExecutableCriteria(session).list();
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }
    }


  @Test
  public void test11(){
      Session session = HibernateUtil.getSession();
      //开启事务
      Transaction tx=session.beginTransaction();
      Criteria criteria=session.createCriteria(Emp.class);
      Projection projection = Projections.groupProperty("dept.deptno");
      Projection p2 = Projections.rowCount();
      criteria.setProjection(Projections.projectionList().add(projection).add(p2));
      List<Object[]> list = criteria.list();
      for (Object[] item:list) {
          System.out.println(item[0]+"\t"+item[1]);
      }
      tx.commit();
  }


    //10.分页  查询员工表中的4-6条(第二页)数据，每页3条数据
    @Test
    public void test10(){
        Session session = HibernateUtil.getSession();
        //开启事务
        Transaction tx=session.beginTransaction();
        int pageSize=3;//每页3条记录
        int pageIndex=2; //显示第二页的数据
        Criteria criteria2=session.createCriteria(Emp.class);
        //数据的拎取
        criteria2.setFirstResult((pageIndex-1)*pageSize);
        criteria2.setMaxResults(pageSize);
        List<Emp> list = criteria2.list();
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }
        tx.commit();
    }

    //09. 排序   查询工号大于0的员工，查询结果按编号升序排列
    @Test
    public void test9(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria=session.createCriteria(Emp.class);
        Criterion criterion= Restrictions.gt("empno",0);

        criteria.add(criterion).addOrder(Order.asc("empno"));
        List<Emp> list = criteria.list();
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }
        tx.commit();
    }

    /*  8.如何查找出符合以下条件的员工信息：
		地址 = ‘bj’
		编号大于0
	 * */
    @Test
    public void test8(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria=session.createCriteria(Emp.class);
        //01.构建所有可能的条件
        EmpCondition condition=new EmpCondition();
        /*condition.setEmpno(0);*/
        condition.setEmpcity("bj");
        //02.动态添加条件
        if (condition.getEmpno()!=null) {
            criteria.add(Restrictions.gt("empno",condition.getEmpno()));
        }
        if (condition.getEmpcity()!=null) {
            criteria.add(Restrictions.ilike("empcity",condition.getEmpcity(),MatchMode.ANYWHERE));
        }
        //03.执行查询
        List<Emp> list = criteria.list();
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }
        tx.commit();
    }

    /*07.集合运算  查询 没有员工的部门(公司准备将其取缔)
	Restrictions.isEmpty( )*/
    @Test
    public void test7(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria=session.createCriteria(Dept.class);
        Criterion criterion= Restrictions.isEmpty("emps"); //属性编程
        criteria.add(criterion);
        List<Dept> list = criteria.list();
        for (Dept dept : list) {
            System.out.println(dept.getDeptname());
        }
        tx.commit();
    }

    //06. and  过滤    查找地址是bj 并且  名称中包含 “小” 的员工信息
    //当需要限定多个条件的时候使用
    @Test
    public void test6(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria=session.createCriteria(Emp.class);
        Criterion criterion1 = Restrictions.eq("empcity", "sh");
        Criterion criterion2 = Restrictions.ilike("empname", "晓",MatchMode.ANYWHERE);
        Criterion criterion3=null;
        Criterion and = Restrictions.and(criterion1,criterion2);
        criteria.add(and);
        List<Emp> list = criteria.list();
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }
        tx.commit();
    }

    //05.字符串模式匹配    查询员工   地址   中包含“s”的所有员工，忽略大小写
    //Restrictions.ilike( )  //Ignore 忽略大小写Like
    @Test
    public void t5(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria=session.createCriteria(Emp.class);
        Criterion criterion = Restrictions.ilike("empcity","S",MatchMode.ANYWHERE);
        criteria.add(criterion);
        List<Emp> list = criteria.list();
        for (Emp emp : list) {
            System.out.println(emp.getEmpname());
        }
        tx.commit();
    }

    //04.范围运算        查询地址为bj或者sh的员工信息
    @Test
    public void t4(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria=session.createCriteria(Emp.class);
        //将bj和sh放入List<String>
        List<String> collection=new ArrayList<String>();
        collection.add("bj");
        collection.add("sh");
        Criterion criterion = Restrictions.in("empcity", collection);
        criteria.add(criterion);
        List<Emp> list = criteria.list();

        for (Emp emp: list) {
            System.out.println(emp.getEmpname());
        }

        tx.commit();
    }

    //案例3：关联查询  查询      财务部   所有    员工信息
    @Test
    public void test3(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria = session.createCriteria(Emp.class);
        criteria.createAlias("dept","d");
        Criterion criterion = Restrictions.eq("d.deptname", "财务部");
        criteria.add(criterion);
        List<Emp> list = criteria.list();
        for (Emp dept : list) {
            System.out.println(dept.getEmpname());
        }
        tx.commit();
    }

    @Test
    //1.查询开发部的信息
    public void t2(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Criteria criteria = session.createCriteria(Dept.class);
        Criterion criterion=Restrictions.eq("deptname","开发部");
        criteria.add(criterion);

        List<Dept> list = criteria.list();
        for (Dept dept : list) {
            System.out.println(dept.getDeptname());
        }
        tx.commit();
    }

    @Test
    //1.检索所有的部门集合
    public void t1(){
        //HibernateUtil 管理session   ThreadLocal  Tomcat：2000
        Session session = HibernateUtil.getSession();
        System.out.println(session);
        //01.开始一个事务
        //事务分类：分成（声明式事务）  和  （编程式事务） 手工  tx.commit();

        Transaction tx=session.beginTransaction();
        Criteria criteria = session.createCriteria(Dept.class);
        List<Dept> list = criteria.list();
        for (Dept dept : list) {
            System.out.println(dept.getDeptname());
        }
        tx.commit();
    }
}
