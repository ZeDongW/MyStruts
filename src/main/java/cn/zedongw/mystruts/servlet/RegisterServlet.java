package cn.zedongw.mystruts.servlet;

import cn.zedongw.mystruts.framework.action.RegisterAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RegisterServlet
 * @Description: 注册控制器
 * @Author ZeDongW
 * @Date 2019/11/26/0026 6:28
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class RegisterServlet extends HttpServlet {
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

        //注册
        service.register(user);

        resp.sendRedirect(req.getContextPath() + "/login.jsp");*/

        RegisterAction registerAction = new RegisterAction();

        Object uri = registerAction.register(req, resp);

        if (uri instanceof String){
            resp.sendRedirect((String) uri);
        } else {
            ((RequestDispatcher) uri).forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
