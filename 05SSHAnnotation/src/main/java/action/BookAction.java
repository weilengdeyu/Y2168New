package action;/**
 * Created by Happy on 2018-11-22.
 */

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import entity.Book;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.IBookService;

import javax.annotation.Resource;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-22
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
@Controller
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
public class BookAction extends ActionSupport {
    private Book book;
    @Resource
    IBookService bookService;
    @org.apache.struts2.convention.annotation.Action(value = "addBook",results={@Result(name = "success",location = "/success.jsp")})
    public String addBook(){
        System.out.println(1);
        System.out.println("book"+book);
        System.out.println(bookService);
        int result = bookService.addBook(book);
        if (result>0){
            return SUCCESS;
        }else{
            return "add";
        }
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public IBookService getBookService() {
        return bookService;
    }

    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }
}
