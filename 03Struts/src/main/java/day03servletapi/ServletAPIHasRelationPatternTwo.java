package day03servletapi;/**
 * Created by Happy on 2018-11-15.
 */

import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-15
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class ServletAPIHasRelationPatternTwo implements Action,ServletRequestAware{
    HttpServletRequest request;
    @Override
    public String execute() throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("msg","ServletRequestAware");
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
}
