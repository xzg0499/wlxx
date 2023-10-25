package com.xzg.wlxx.ast.processor;

import java.util.HashMap;

/**
 * @author XiaoZG
 */
public class RouterManager {

    public static final String INIT_CLASS = "com.xzg.wlxx.common.Demo";
    public static final String INIT_PACKAGE = "com.xzg.wlxx.common";
    public static final String INIT_SIMPLE_CLASS = "Demo";
    public static final String INIT_METHOD = "initRouter";
    public static final String ROUTER_TAG = "router";

    /**
     * key是scheme value是对应的类名;
     */
    private HashMap<String, String> map = new HashMap<>();
    /**
     * key是scheme value是对应的类示例;
     */
    private HashMap<String, String> routerMap = new HashMap<>();

    private static final class Host {
        private static final RouterManager instance = new RouterManager();
    }

    private RouterManager() {
    }

    /**
     * 单例模式
     */
    public static RouterManager getInstance() {
        return Host.instance;
    }

    /**
     * 初始化Router列表：唯一不同地方
     */
    public void initRouter() {
        try {
            //调用动态生成的文件
            Class.forName(INIT_CLASS).getMethod(INIT_METHOD).invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册Router
     */
    public void register(String uri, String className) {
        if (className != null && uri != null) {
            map.put(uri, className);
            routerMap.put(uri, null);
        }
    }

    /**
     * 输出所有Router
     */
    public void showAllScheme() {
        System.out.println("RouterManager:" + map.toString());
    }

    /**
     * 根据scheme执行不同的分发逻辑
     */
    public boolean dispatch(String scheme) {
        try {
            if (routerMap.containsKey(scheme)) {

                return true;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
