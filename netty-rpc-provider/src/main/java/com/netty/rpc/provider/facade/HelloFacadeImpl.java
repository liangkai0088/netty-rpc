package com.netty.rpc.provider.facade;

import com.netty.rpc.provider.annotation.RpcService;

/**
 * demo 方法实现
 * @author liangkai
 */
@RpcService(serviceInterface = HelloFacade.class, serviceVersion = "1.0.0")
public class HelloFacadeImpl implements HelloFacade{
    /**
     * 方法实现
     * @param name 入参
     * @return 结果
     */
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
