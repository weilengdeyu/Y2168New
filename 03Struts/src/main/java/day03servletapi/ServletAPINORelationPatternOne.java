package day03servletapi;/**
 * Created by Happy on 2018-11-15.
 */

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-15
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class ServletAPINORelationPatternOne implements Action{
    @Override
    public String execute() throws Exception {
        //解耦合
        ActionContext context = ActionContext.getContext();
        //获取session
      /*  Map<String, Object> map = context.getSession();
        map.put("msg","我是解耦的第一种方式");//code相当于将数据放到了session中*/

        //获取request
        Map<String,Object> request=(Map<String,Object>)context.get("request");
        request.put("msg","request msg");
        System.out.println(request);
        //session类型  HttpSession   session.setAttribute();
        return SUCCESS;
    }
}
