package com.netty.rpc.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * rpc服务配置文件
 * @author liangkai
 */
@Data
@ConfigurationProperties(prefix = "netty.rpc")
public class RpcProperties {

    /**
     * rpc服务端口
     */
    private int servicePort;

    /**
     * rpc服务注册地址
     */
    private String registryAddr;

    /**
     * 注册中心类型
     */
    private String registryType;

}
