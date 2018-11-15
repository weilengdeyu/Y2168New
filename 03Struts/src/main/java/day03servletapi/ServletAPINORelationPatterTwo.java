package day03servletapi;/**
 * Created by Happy on 2018-11-15.
 */

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-15
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class ServletAPINORelationPatterTwo implements Action,SessionAware{
    Map<String, Object> map;
    @Override
    public String execute() throws Exception {
        map.put("msg","Hello SessionAware");
        //session类型  HttpSession   session.setAttribute();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.map=map;
    }
}
