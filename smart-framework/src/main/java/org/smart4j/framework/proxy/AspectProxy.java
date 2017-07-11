package org.smart4j.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 切面代理， 提供一个模板方法，并在该抽象类的具体实现中扩展相应的抽象方法
 * @since 2017-07-11.
 */
public abstract class AspectProxy implements Proxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] methodParams = proxyChain.getMethodParams();
        begin();
        try {
            if (intercept(targetClass, targetMethod, methodParams)) {
                before(targetClass, targetMethod, methodParams);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, methodParams);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            LOGGER.error("proxy fail", e);
            error(targetClass, targetMethod, methodParams, e);
        }
        end();
        return result;
    }

    public void begin() {}

    // 拦截方法
    public boolean intercept(Class<?> clz, Method method, Object[] params) throws Throwable {
        return true;
    }

    public void before(Class<?> clz, Method method, Object[] params) throws Throwable {

    }

    public void after(Class<?> clz, Method method, Object[] params) throws Throwable {

    }

    // 执行代理所抛出的异常
    public void error(Class<?> clz, Method method, Object[] params, Throwable e) {

    }

    public void end() {}
}
