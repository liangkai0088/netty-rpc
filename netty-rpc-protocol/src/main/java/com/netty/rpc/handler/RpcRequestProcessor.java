package com.netty.rpc.handler;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 创建线程池单例
 * @author liangkai
 */
public class RpcRequestProcessor {
    /**
     * 核心线程数
     */
    private final static Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    /**
     * 线程池最大线程数
     */
    private final static Integer MAXIMUM_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2 ;

    /**
     * 闲时：线程保留时间
     */
    private final static Long KEEP_ALIVE_TIME = 0L;

    /**
     * 阻塞队列
     */
    private final static BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>(1024);


    /**
     * 拒绝策略：由提交的线程执行任务
     */
    private final static  RejectedExecutionHandler REJECTED_EXECUTION_HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();

    /**
     * 线程池
     */
    private static final ThreadFactory THREAD_FACTORY =
            new ThreadFactoryBuilder().setNameFormat("async-task-executor-%d").build();


    /**
     * 创建线程池
     */
    public static final ThreadPoolExecutor THREAD_POOL =  new ThreadPoolExecutor(CORE_POOL_SIZE,MAXIMUM_POOL_SIZE,KEEP_ALIVE_TIME,TimeUnit.MILLISECONDS, WORK_QUEUE,THREAD_FACTORY,REJECTED_EXECUTION_HANDLER);

    /**
     * 单例方法 获取线程池
     * @return 线程池
     */
    public static ExecutorService getThreadPool(){
        return THREAD_POOL;
    }

    /**
     * 处理任务方法
     * @param task request服务请求
     */
    public static void submitRequest(Runnable task){
        getThreadPool().submit(task);
    }
}
