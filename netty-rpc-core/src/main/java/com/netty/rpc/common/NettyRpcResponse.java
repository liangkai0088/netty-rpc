package com.netty.rpc.common;

import lombok.Data;

import java.io.Serializable;

/**
 * rpc response
 * @author liangkai
 */
@Data
public class NettyRpcResponse implements Serializable {
    /**
     * 请求结果
     */
    private Object data;

    /**
     * 错误信息
     */
    private String message;
}
