package org.smart4j.framework;

import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author liuzm@gveoe.cn
 * @since 2017-07-06.
 */
public final class HelperLoader {

    public static void init() {
        // AopHelper要在IocHelper之前加载
        // 因为首先需要通过AopHelper获取代理对象，然后才能通过IocHelper进行依赖注入
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> clz : classList) {
            ClassUtil.loadClass(clz.getName(), true);
        }
    }

    public static void main(String[] args) {
        init();
    }
}
