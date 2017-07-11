package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 代理管理器，用来创建代理对象（切面类调用）
 * @since 2017-07-11.
 */
public class ProxyManager {

    /**
     * 创建代理
     * @param targetClass
     * @param proxyList
     * @param <T>
     * @return
     */
    public static <T> T createProxy(final Class<T> targetClass, final List<Proxy> proxyList) {
        // 使用CGLib提供的Enhance#create方法来创建代理对象
        // 将intercept的参数传入ProxyChain的构造器中
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            public Object intercept(Object targetObj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass, targetObj, method, methodProxy, objects).doProxyChain();
            }
        });
    }
}
