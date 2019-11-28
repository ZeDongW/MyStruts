package cn.zedongw.mystruts.entity;

/**
 * @ClassName Users
 * @Description: 用户实体类
 * @Author ZeDongW
 * @Date 2019/11/26/0026 5:59
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class Users {
    private String userName; //用户名

    private String pwd; //密码

    public Users() {
    }

    public Users(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
