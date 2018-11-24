package service.impl;/**
 * Created by Happy on 2018-11-22.
 */

import dao.IBookDAO;
import entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.IBookService;

import javax.annotation.Resource;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-22
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {
    @Resource
    IBookDAO bookDAO;
    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int addBook(Book book) {
        return bookDAO.addBook(book);
    }

    public IBookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
}
