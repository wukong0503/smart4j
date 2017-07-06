package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法映射注解
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-06.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Action {

    /** 请求方式 **/
    String method() default "GET";

    /** 映射路径 **/
    String value();
}
