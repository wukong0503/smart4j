package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装 Action 信息
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-06.
 */
public class Handler {

    private Class<?> controllerClass;

    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
