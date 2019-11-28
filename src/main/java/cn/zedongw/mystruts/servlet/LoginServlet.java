package cn.zedongw.mystruts.servlet;

import cn.zedongw.mystruts.entity.Users;
import cn.zedongw.mystruts.framework.action.LoginAction;
import cn.zedongw.mystruts.framework.action.RegisterAction;
import cn.zedongw.mystruts.service.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description: 登录控制器
 * @Author ZeDongW
 * @Date 2019/11/26/0026 6:19
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//实例化业务逻辑层
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

        //登录
        Users loginUser = service.login(user);

        if (loginUser == null) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }*/
        LoginAction loginAction = new LoginAction();
        Object uri = loginAction.login(req, resp);

        // 跳转
        if (uri instanceof String) {
            resp.sendRedirect(req.getContextPath() + uri.toString());
        } else {
            ((RequestDispatcher)uri).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
