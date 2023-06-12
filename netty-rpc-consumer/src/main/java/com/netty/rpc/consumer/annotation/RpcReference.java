package com.netty.rpc.consumer.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务引用注解
 * @author liangkai
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Autowired
public @interface RpcReference {

    /**
     * 服务版本号
     * @return 默认1.0
     */
    String serviceVersion() default "1.0";

    /**
     * 注册中心类型
     * @return 默认zookeeper
     */
    String registryType() default "ZOOKEEPER";

    /**
     * 注册中心地址
     * @return "127.0.0.1:2181"
     */
    String registryAddress() default "127.0.0.1:2181";

    /**
     * 超时
     * @return 默认5秒
     */
    long timeout() default 5000;

}
