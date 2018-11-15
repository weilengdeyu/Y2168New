package day01;/**
 * Created by Happy on 2018-11-13.
 */

import com.opensymphony.xwork2.Action;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-13
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
//预习：如何让一个普通类称为一个Action
 //   实现了一个接口
public class HelloAction implements Action{
    @Override
    //逻辑视图名
    public String execute() throws Exception {
        return SUCCESS;
    }
}
