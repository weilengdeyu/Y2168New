授课笔记
2018年10月27日08:42:13
1.区别
HQL：Hibernate  Query Language 面向对象的查询语言（Java编程语言的维度）
面向类型和属性的（类名和属性名严格区分大小写）
SQL：  数据库的查询语法
面向表和字段的（表和字段是不区分大小写的）  数据库维度
2.回顾>学习新技能
3.Hibernate提供了5种检索对象的方式
       1.导航对象图检索方式：根据已经加载的对象导航到其他对象
         from  Emp e group by e.dept.deptName
       2.OID检索方式：按照对象的OID来检索对象  get/load
       3.HQL检索方式：使用面向对象的HQL查询语言  from Student
       4.QBC检索方式：使用QBC(Query By Criteria)API来检索对象，这种API封装了基于字符串形式的查询语句，\
      提供了更加面向对象的查询接口
       5.本地SQL检索方式：使用本地数据库的SQL查询语句
       createSqlQuery();
4.查询所有部门信息
HQL  from Dept
Criteria 查询

5.三种编译工具
 Ant
 Maven
 Gradle

6.artifactid  模块
  groupid :组织的倒序  com.alibaba  com.jd.

7.Class  Class:所有类的类型
class 是一个关键字
public class Student{

}

2018年10月27日 12:15:25
1.4个例子 30分钟
2.部署mblog 周二 ！！！碰到什么问题
3.SSM框架---登录
下周三  考核


授课计划
1.Hibernate   Criteria查询

2.Hibernate   二缓


3.Oracle 最少两次

4.下下周  Struts2

5.SSH两套整合  两次课 下下周 （综合测试）

6.超哥讲Hadoop ++++刘少伟老师补充真实项目

hadoop
zookeeper
hbase

7.SSM项目

8.面试指导 ------》

2018年10月30日09:26:543
1.Restrictions.ilike(属性名,属性值,MatchMode匹配的模式 AnyWhere等等。)
2.以下语句的含义
          select
                1
            from
                Emp
            where
                this_.deptno=1


  select
        this_.deptno as deptno1_0_0_,
        this_.deptname as deptname2_0_0_
    from
        y2168.Dept this_
    where
        not exists (
            select
                1
            from
                y2168.Emp
            where
                this_.deptno=deptno
        )
3.视图Model
Login
Business  Model

























