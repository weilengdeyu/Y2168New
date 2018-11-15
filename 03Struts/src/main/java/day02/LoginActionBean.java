package day02;/**
 * Created by Happy on 2018-11-14.
 */

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-14
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class LoginActionBean implements Action,ModelDriven<UserInfo>{
    private UserInfo userInfo=new UserInfo();
    public String execute() throws Exception {
        System.out.println(userInfo.getUsername()+"=================");
        if (userInfo.getUsername().equals("1")&&userInfo.getPassword().equals("1")) {
            return SUCCESS;
        }else {
            return LOGIN;
        }

    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public UserInfo getModel() {
        return userInfo;
    }
}
