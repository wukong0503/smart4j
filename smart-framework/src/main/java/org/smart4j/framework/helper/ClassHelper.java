package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-06.
 */
public final class ClassHelper {
    /**
     * 定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下的所有 Service 类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(Service.class)) {
                classSet.add(clz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下的所有 Controller 类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(Controller.class)) {
                classSet.add(clz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下的所有 Bean 类（包括 Service、Controller 等）
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }

    /**
     * 获取应用包名下某父类（或接口）的所有子类（或实现类）
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET) {
            if (superClass.isAssignableFrom(clz) && !superClass.equals(clz)) {
                classSet.add(clz);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某注解的所有类
     * @param annotationClass
     * @return
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(annotationClass)) {
                classSet.add(clz);
            }
        }
        return classSet;
    }

}
