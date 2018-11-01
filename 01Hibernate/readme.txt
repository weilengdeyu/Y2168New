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

4.Order.asc(),Order.desc()  问题是，当我通过Order.asc()调度完成后，返回的是一个Order对象，Java领域，知道
对象名.静态方法（）被支持的，但是我们只能点出来desc(），但是asc()无法再次调度。
如果我们调度多次排序的方法，以最后一次为准。

5.分组的底层原理
王鸿：:::::::

6.Criteria 接口   作为 QBC检索基础接口   session.createCriteria()

  Criterion 接口    做的是查询的条件   ，转向了 一个类 Restrictions.eq()    返回 ：Criterion

  Projection 投影 Projections类，  count()  rowCount()

  离线 ：
  attache  附加

  detach  分离


hibernate 中的session你如何看待？元芳你怎么看》？
 session实例  由工厂创建
 session 每一个线程，都有一份自己的session
 Hibernate 中 Session  是一个接口，他的实现类 SessionImpl  -----》重要的属性和属性 ，connection
session可以看成是经过特殊加工，包装过的一个增强版的Connection
周二，
周六的时候:自己的微信公众号。

2018年10月30日12:31:24
1.MyBatis 20页文档
2.聊聊Hibernate中的session


2018年11月1日09:17:37
1.离线查询DetachedCriteria
 可以将条件拼接和真实的查询分离到 Service和DAO
 可以在没有session的情况下进行操作
2.一级缓存
缓存：是计算机领域的概念，它介于应用程序和永久性数据存储源之间。

缓存：一般人的理解是在内存中的一块空间，其实也可以将二级缓存配置到硬盘。
用白话来说，就是一个存储数据的容器。我们关注的是，哪些数据需要被放入二级缓存。

缓存作用：降低应用程序直接读写数据库的频率，从而提高程序的运行性能。
缓存中的数据是数据存储源中数据的拷贝。缓存的物理介质通常是【内存】。

01.Session内的缓存即一级缓存,内置且不能被卸载，一个事务内有效。在这个空间存放了相互关联的Java对象，
这种位于Session缓存内的对象也被称为持久化对象，Session负责根据持久化对象的状态变化来同步更新数据库。

02.Session为应用程序提供了管理缓存的方法:
evict(Object o)
clear()
03.金牌结论一级缓存
一级缓存的生命周期和session的生命周期一致，当前session一旦关闭，一级缓存就消失了，
因此一级缓存也叫session级的缓存或事务级缓存，一级缓存只存实体对象，它不会缓存一般的对象属性（查询缓存可以），
即当获得对象后，就将该对象缓存起来，如果在同一session中再去获取这个对象时，它会先判断在缓存中有没有该对象的id，
如果有则直接从缓存中获取此对象，反之才去数据库中取，取的同时再将此对象作为一级缓存处理。

二级缓存
   一定是可以配置的，默认情况下Hibernate是关闭二级缓存的。
   MyBatis 默认是开启二级缓存。MyBatis默认虽然开启了二级缓存 ，但不能使用。

Hibernate 3 或者  4  注意：


配置二级缓存步骤
1.添加依赖
 <!--支持缓存的核心包-->
        <dependency>
            <groupId>net.sf.ehcache</groupId>
            <artifactId>ehcache</artifactId>
            <version>2.4.3</version>
        </dependency>
        <!--支持缓存的依赖包-->
        <dependency>
            <groupId>backport-util-concurrent</groupId>
            <artifactId>backport-util-concurrent</artifactId>
            <version>3.1</version>
        </dependency>
        <!--这个jar包至关重要-->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-ehcache</artifactId>
            <version>5.0.6.Final</version>
        </dependency>

 2.在hibernarte.cfg.xml中加入两个<property>
   2.1  hibernate.cache.use_second_level_cache  true
    <property name="hibernate.cache.use_second_level_cache">true</property>
     *3.配置二级缓存的供应商
     <property name="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</property>
   2.2  缓存供应商
   EHCacheProvider
   hibernate5中有区别  ：EhCacheRegionFactory实现类


 3.设置你要缓存的类以及他的策略
    <class-cache class="cn.happy.entity.Dept" usage="read-write"></class-cache>、

 4.在resource目录下添加一个文件 ehcache.xml文件


小Tip：
hibernate-core  和 hibernate-ehcache 两个版本一致。


4.二级缓存内存数据存储结构
1.缓存+++博客
30-40页 MyBatis或者是Spring文档：
2.信息MIS管理雏形
































































