package com.netty.rpc.common;

import lombok.Data;


/**
 * 注册服务元数据
 * @author liangkai
 */
@Data
public class ServiceMeta {

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 版本号
     */
    private String serviceVersion;

    /**
     * 服务地址
     */
    private String serviceAddr;

    /**
     * 端口号
     */
    private int servicePort;

}
