package com.netty.rpc.common;

/**
 * 服务标识
 * @author liangkai
 */
public class RpcServiceHelper {
    /**
     * 服务标识键
     * @param serviceName 服务名称
     * @param serviceVersion 版本
     * @return 服务名#版本
     */
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("#", serviceName, serviceVersion);
    }
}
