package cn.zedongw.mystruts.framework.bean;

import java.util.Map;

/**
 * @ClassName ActionMapping
 * @Description: xml配置文件映射
 * @Author ZeDongW
 * @Date 2019/11/27/0027 6:40
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class ActionMapping {

    private String name; //请求名称

    private String className; //请求处理类类名

    private Map<String, Result> results; // 结果视图集合

    public ActionMapping() {
    }

    public ActionMapping(String name, String className, Map<String, Result> results) {
        this.name = name;
        this.className = className;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Result> getResults() {
        return results;
    }

    public void setResults(Map<String, Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ActionMapping{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", results=" + results +
                '}';
    }
}
