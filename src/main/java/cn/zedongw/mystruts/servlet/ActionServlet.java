package cn.zedongw.mystruts.servlet;

import cn.zedongw.mystruts.framework.bean.ActionMapping;
import cn.zedongw.mystruts.framework.bean.ActionMappingManager;
import cn.zedongw.mystruts.framework.bean.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName ActionServlet
 * @Description: 核心控制器，处理所有action
 * @Author ZeDongW
 * @Date 2019/11/27/0027 7:15
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class ActionServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger(ActionServlet.class.getName());

    private ActionMappingManager actionMappingManager;

    @Override
    public void init(ServletConfig config) throws ServletException {

        logger.info("ActionServlet.init()");

        actionMappingManager = new ActionMappingManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 1. 获取请求uri, 得到请求路径名称   【login】
            String uri = req.getRequestURI();

            // 得到 login
            String actionName = uri.substring(uri.lastIndexOf("/")+1, uri.indexOf(".action"));

            // 2. 根据路径名称，读取配置文件，得到类的全名
            ActionMapping actionMapping = actionMappingManager.getActionMapping(actionName);
            String className = actionMapping.getClassName();

            // 3. 反射： 创建对象，调用方法； 获取方法返回的标记
            Class<?> clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            Method m = clazz.getDeclaredMethod(actionName, HttpServletRequest.class,HttpServletResponse.class );

            // 调用方法返回的标记
            String returnFlag =  (String) m.invoke(obj, req, resp);

            // 4. 拿到标记，读取配置文件得到标记对应的页面 、 跳转类型
            Result result = actionMapping.getResults().get(returnFlag);
            // 类型
            String type = result.getType();
            // 页面
            String page = result.getPage();

            // 跳转
            if ("redirect".equals(type)) {
                resp.sendRedirect(req.getContextPath() + page);
            } else {
                req.getRequestDispatcher(page).forward(req, resp);
            }
        } catch (Exception e) {
            logger.error("处理请求发生异常");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
