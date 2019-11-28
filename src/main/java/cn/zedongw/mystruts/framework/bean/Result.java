package cn.zedongw.mystruts.framework.bean;

/**
 * @ClassName Result
 * @Description: 请求处理结果返回视图类
 * @Author ZeDongW
 * @Date 2019/11/27/0027 6:44
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class Result {

    private String name; // 跳转的结果标记

    private String type; // 跳转类型，默认为转发； "redirect"为重定向

    private String page; // 跳转的页面

    public Result() {
    }

    public Result(String name, String type, String page) {
        this.name = name;
        this.type = type;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", page='" + page + '\'' +
                '}';
    }
}
