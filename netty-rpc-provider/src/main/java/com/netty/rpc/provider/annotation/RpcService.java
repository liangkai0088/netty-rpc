package com.netty.rpc.provider.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * rpc服务注解 通过注解来暴露服务
 * @author liangkai
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface RpcService {

    /**
     * 服务接口
     * @return 服务接口类
     */
    Class<?> serviceInterface() default Object.class;

    /**
     * 接口版本
     * @return 默认1.0
     */
    String serviceVersion() default "1.0";
}
