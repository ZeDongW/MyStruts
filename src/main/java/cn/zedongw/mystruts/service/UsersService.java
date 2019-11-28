package cn.zedongw.mystruts.service;

import cn.zedongw.mystruts.dao.UsersDao;
import cn.zedongw.mystruts.entity.Users;

/**
 * @ClassName UsersService
 * @Description: 用户业务逻辑层
 * @Author ZeDongW
 * @Date 2019/11/26/0026 6:11
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class UsersService {

    //实例化持久层
    UsersDao dao = new UsersDao();

    /** @MethodName: login
      * @Description: 登录
      * @Param: [user]
      * @Return: cn.zedongw.mystruts.entity.Users
      * @Author: ZeDongW
      * @Date: 2019/11/26/0026 6:12
      **/
    public Users login(Users user){
        return dao.login(user);
    }

    /** @MethodName: register
      * @Description: 注册
      * @Param: [user]
      * @Return: void
      * @Author: ZeDongW
      * @Date: 2019/11/26/0026 6:13
      **/
    public void register(Users user){
        dao.register(user);
    }
}
