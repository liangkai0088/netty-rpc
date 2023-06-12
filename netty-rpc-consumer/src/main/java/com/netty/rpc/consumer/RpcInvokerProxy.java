package com.netty.rpc.consumer;

import com.netty.rpc.common.NettyRpcFuture;
import com.netty.rpc.common.NettyRpcRequestHolder;
import com.netty.rpc.common.NettyRpcResponse;
import com.netty.rpc.common.NettyRpcRequest;
import com.netty.rpc.protocol.NettyRpcProtocol;
import com.netty.rpc.protocol.MsgHeader;
import com.netty.rpc.protocol.MsgType;
import com.netty.rpc.protocol.ProtocolConstants;
import com.netty.rpc.provider.registry.RegistryService;
import com.netty.rpc.serialization.SerializationTypeEnum;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class RpcInvokerProxy implements InvocationHandler {

    private final String serviceVersion;
    private final long timeout;
    private final RegistryService registryService;

    public RpcInvokerProxy(String serviceVersion, long timeout, RegistryService registryService) {
        this.serviceVersion = serviceVersion;
        this.timeout = timeout;
        this.registryService = registryService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        NettyRpcProtocol<NettyRpcRequest> protocol = new NettyRpcProtocol<>();
        MsgHeader header = new MsgHeader();
        long requestId = NettyRpcRequestHolder.REQUEST_ID_GEN.incrementAndGet();
        header.setMagic(ProtocolConstants.MAGIC);
        header.setVersion(ProtocolConstants.VERSION);
        header.setRequestId(requestId);
        header.setSerialization((byte) SerializationTypeEnum.HESSIAN.getType());
        header.setMsgType((byte) MsgType.REQUEST.getType());
        header.setStatus((byte) 0x1);
        protocol.setHeader(header);

        NettyRpcRequest request = new NettyRpcRequest();
        request.setServiceVersion(this.serviceVersion);
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setParams(args);
        protocol.setBody(request);

        RpcConsumer rpcConsumer = new RpcConsumer();
        NettyRpcFuture<NettyRpcResponse> future = new NettyRpcFuture<>(new DefaultPromise<>(new DefaultEventLoop()), timeout);
        NettyRpcRequestHolder.REQUEST_MAP.put(requestId, future);
        rpcConsumer.sendRequest(protocol, this.registryService);

        return future.getPromise().get(future.getTimeout(), TimeUnit.MILLISECONDS).getData();
    }
}
