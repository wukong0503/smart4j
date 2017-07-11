package org.smart4j.framework.proxy;

/**
 * 代理接口
 * @since 2017-07-11.
 */
public interface Proxy {

    // 执行链式代理
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
