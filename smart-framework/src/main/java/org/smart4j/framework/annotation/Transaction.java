package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义需要事务控制的方法
 * @since 2017-07-12.
 */
@Target(ElementType.METHOD) // 该注解只能用于方法级别
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {
}
