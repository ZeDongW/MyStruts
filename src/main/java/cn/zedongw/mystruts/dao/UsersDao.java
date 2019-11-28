package cn.zedongw.mystruts.dao;

import cn.zedongw.mystruts.entity.Users;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName UsersDao
 * @Description: 用户类持久层
 * @Author ZeDongW
 * @Date 2019/11/26/0026 5:59
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class UsersDao {

    private Logger logger = LogManager.getLogger(UsersDao.class.getName());

    /** @MethodName: login
     * @Description: 模拟登录
     * @Param: [user]
     * @Return: cn.zedongw.mystruts.entity.Users
     * @Author: ZeDongW
     * @Date: 2019/11/26/0026 6:05
     **/
    public Users login(Users user){
        //登录成功
        if ("tom".equals(user.getUserName()) && "888".equals(user.getPwd())){
            logger.info("----logger---登录成功，用户名{}", user.getUserName());
            System.out.println("----sout--登录成功，用户名" + user.getUserName());
            return user;
        }
        //登录失败
        return null;
    }

    /** @MethodName: register
     * @Description: 登模拟注册
     * @Param: [user]
     * @Return: void
     * @Author: ZeDongW
     * @Date: 2019/11/26/0026 6:08
     **/
    public void register(Users user){
        logger.info("注册成功，用户：{}", user.getUserName());
    }
}
