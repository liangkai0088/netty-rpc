package com.netty.rpc.provider.facade;

/**
 * demo接口
 * @author liangkai
 */
public interface HelloFacade {
    /**
     * demo方法
     * @param name 入参
     * @return hello + name
     */
    String hello(String name);
}
