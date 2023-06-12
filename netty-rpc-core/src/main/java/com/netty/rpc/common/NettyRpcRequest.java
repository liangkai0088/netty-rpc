package com.netty.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * rpc request
 * @author liangkai
 */
@Data
public class NettyRpcRequest implements Serializable {
    /**
     * 版本
     */
    private String serviceVersion;
    /**
     * 服务接口名
     */
    private String className;
    /**
     * 服务方法名
     */
    private String methodName;
    /**
     * 方法参数列表
     */
    private Object[] params;
    /**
     * 方法参数类型列表
     */
    private Class<?>[] parameterTypes;
}
