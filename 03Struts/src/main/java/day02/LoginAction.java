package day02;/**
 * Created by Happy on 2018-11-14.
 */

import com.opensymphony.xwork2.Action;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-14
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class LoginAction implements Action{
    private String username;//username成员变量的值就是Strut框架装配的。
    private String password;
    public String execute() throws Exception {
        System.out.println(username+"=================");
        if (username.equals("1")&&password.equals("1")) {
            return SUCCESS;
        }else {
            return LOGIN;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
