package com.netty.rpc.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class NettyRpcProtocol<T> implements Serializable {
    private MsgHeader header;
    private T body;
}
