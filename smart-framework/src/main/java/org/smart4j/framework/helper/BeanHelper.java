package org.smart4j.framework.helper;

import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手类
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-06.
 */
public final class BeanHelper {

    /**
     * 定义 Bean 映射（用于存放Bean类与Bean实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取 Bean 实例
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取 Bean 实例
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clz) {
        if (!BEAN_MAP.containsKey(clz)) {
            throw new RuntimeException("can not get bean by class: "  + clz);
        }
        return (T) BEAN_MAP.get(clz);
    }

    /**
     * 设置Bean实例
     * @param clz
     * @param object
     */
    public static void setBean(Class<?> clz, Object object) {
        BEAN_MAP.put(clz, object);
    }
}
