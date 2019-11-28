package cn.zedongw.mystruts.framework.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ActionMappingManager
 * @Description: 加载配置文件获取所有的acton
 * @Author ZeDongW
 * @Date 2019/11/27/0027 6:49
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class ActionMappingManager {

    private Logger logger = LogManager.getLogger(ActionMappingManager.class.getName());

    // 保存action的集合
    private Map<String,ActionMapping> allActions ;

    /** @MethodName: ActionMappingManager
      * @Description: 构造方法，加载mystruts配置文件
      * @Param: []
      * @Return:
      * @Author: ZeDongW
      * @Date: 2019/11/27/0027 7:12
      **/
    public ActionMappingManager(){
        allActions = new HashMap<String,ActionMapping>();
        // 初始化
        this.init();
    }

    /** @MethodName: getActionMapping
      * @Description: 根据请求名称返回对应的action请求
      * @Param: [actionName]
      * @Return: cn.zedongw.mystruts.framework.bean.ActionMapping
      * @Author: ZeDongW
      * @Date: 2019/11/27/0027 7:13
      **/
    public ActionMapping getActionMapping(String actionName) {
        if (actionName == null) {
            logger.error("传入参数有误，请查看mystruts.xml配置的路径。");
            throw new RuntimeException("传入参数有误，请查看mystruts.xml配置的路径。");
        }

        ActionMapping actionMapping = allActions.get(actionName);
        if (actionMapping == null) {
            logger.error("请求路径在struts.xml中找不到，请检查");
            throw new RuntimeException("路径在struts.xml中找不到，请检查");
        }
        return actionMapping;
    }

    /** @MethodName: init
      * @Description: 加载配置文件
      * @Param: []
      * @Return: void
      * @Author: ZeDongW
      * @Date: 2019/11/27/0027 6:50
      **/
    private void init(){
        logger.info("-------------------init读文件-------------------");
        try {
            //dom4j读取配置文件
            SAXReader reader = new SAXReader();

            //获取mystruts文件流
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("mystruts.xml");

            //加载文件
            Document doc = reader.read(resourceAsStream);
            logger.info("-------------------加载文件-------------------");
            //获取根节点
            Element rootElement = doc.getRootElement();

            //得到package节点
            List<Element> packages = rootElement.elements("package");

            //遍历处理package节点
            packages.forEach(ele_package -> {
                //获取package节点底下所有子节点
                List<Element> actions = ele_package.elements();

                //遍历action节点封装ActionMapping对象
                actions.forEach(ele_action -> {
                    //封装ActionMapping对象
                    ActionMapping actionMapping = new ActionMapping();
                    actionMapping.setName(ele_action.attributeValue("name"));
                    actionMapping.setClassName(ele_action.attributeValue("class"));

                    //封装当前aciton节点下所有的结果视图
                    Map<String,Result> resultMap = new HashMap<String, Result>();

                    //获取action节点下所有result子节点
                    List<Element> results = ele_action.elements("result");

                    results.forEach(ele_result -> {
                        // 封装对象
                        Result result = new Result();
                        result.setName(ele_result.attributeValue("name"));
                        result.setType(ele_result.attributeValue("type"));
                        result.setPage(ele_result.getTextTrim());

                        // 添加到集合
                        resultMap.put(result.getName(), result);
                    });
                    // 设置到actionMapping中
                    actionMapping.setResults(resultMap);

                    //actionMapping添加到map集合
                    allActions.put(actionMapping.getName(), actionMapping);
                });
            });



        } catch (DocumentException e) {
            logger.error("加载配置文件mystruts.xml失败");
            throw new RuntimeException(e);
        }
    }
}
