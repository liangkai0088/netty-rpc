package com.netty.rpc.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 保存request
 * @author liangkai
 */
public class NettyRpcRequestHolder {

    /**
     * 记录request id
     */
    public final static AtomicLong REQUEST_ID_GEN = new AtomicLong(0);

    /**
     * 记录相应的request
     */
    public static final Map<Long, NettyRpcFuture<NettyRpcResponse>> REQUEST_MAP = new ConcurrentHashMap<>();
}
