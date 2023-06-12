package com.netty.rpc.common;

import io.netty.util.concurrent.Promise;
import lombok.Data;

/**
 * 设置响应结果
 * @author liangkai
 */
@Data
public class NettyRpcFuture<T> {

    /**
     * 响应结果future
     */
    private Promise<T> promise;

    /**
     * 超时
     */
    private long timeout;

    public NettyRpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }
}
