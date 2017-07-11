package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * @since 2017-07-11.
 */
@Target(ElementType.TYPE) // 只能用于类上
@Retention(RetentionPolicy.RUNTIME) // 运行时存在，可以通过反射读取
public @interface Aspect {

    /**
     * 注解
     */
    Class<? extends Annotation> value();
}
