package dao.impl;/**
 * Created by Happy on 2018-11-22.
 */

import dao.IBookDAO;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-22
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
@Repository("bookDAO")
public class BookDAOImpl implements IBookDAO {
    @Autowired //Spring注解  默认byType
    @Qualifier("sessionFactory")
     //域属性 的自动注入
    SessionFactory sessionFactory;

    @Override
    public int addBook(Book book) {
        System.out.println(book+"================");
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session+"============session");
        Serializable result = session.save(book);
        System.out.println(result+"**********************************");
        return (Integer) result;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
