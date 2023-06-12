package com.netty.rpc.handler;


import com.netty.rpc.common.NettyRpcFuture;
import com.netty.rpc.common.NettyRpcRequestHolder;
import com.netty.rpc.common.NettyRpcResponse;
import com.netty.rpc.protocol.NettyRpcProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RpcResponseHandler extends SimpleChannelInboundHandler<NettyRpcProtocol<NettyRpcResponse>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyRpcProtocol<NettyRpcResponse> msg) {
        long requestId = msg.getHeader().getRequestId();
        NettyRpcFuture<NettyRpcResponse> future = NettyRpcRequestHolder.REQUEST_MAP.remove(requestId);
        future.getPromise().setSuccess(msg.getBody());
    }
}

