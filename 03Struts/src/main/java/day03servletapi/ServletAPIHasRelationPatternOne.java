package day03servletapi;/**
 * Created by Happy on 2018-11-15.
 */

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-15
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class ServletAPIHasRelationPatternOne implements Action{
    @Override
    public String execute() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("msg","ServletActionContext Method");
        return SUCCESS;
    }
}
