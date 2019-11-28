package cn.zedongw.mystruts.framework.action;

import cn.zedongw.mystruts.entity.Users;
import cn.zedongw.mystruts.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RegisterAction
 * @Description: 注册控制器剥离
 * @Author ZeDongW
 * @Date 2019/11/27/0027 5:47
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class RegisterAction {
    public Object register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object uri;
        //实例化业务逻辑层
        UsersService service = new UsersService();

        //获取用户名
        String userName = req.getParameter("userName");

        //获取密码
        String pwd = req.getParameter("pwd");

        //创建对象
        Users user = new Users();

        //设置属性
        user.setUserName(userName);
        user.setPwd(pwd);

        //注册
        service.register(user);

//        resp.sendRedirect(req.getContextPath() + "/login.jsp");
        uri = "registerSuccess";
        return uri;
    }
}
