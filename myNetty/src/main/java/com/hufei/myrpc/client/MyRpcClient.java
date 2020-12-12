package com.hufei.myrpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author:hufei
 * @CreateTime:2020-08-06
 * @Description:rpc客户端
 */
public class MyRpcClient {

    public void start(String host, int port) {
        EventLoopGroup worker = null;
        try {
            //创建工作线程组
            worker = new NioEventLoopGroup();
            //开启client客户端
            Bootstrap bootstrap = new Bootstrap();
            //设置工作线程组
            bootstrap.group(worker)
                    //设置socket通道
                    .channel(NioSocketChannel.class)
                    //设置业务处理handler
                    .handler(new MyClientHandler());
            //建立远程连接
            ChannelFuture future = bootstrap.connect(host, port).sync();
            //关闭连接
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (worker != null) {
                //关闭工作线程
                worker.shutdownGracefully();
            }
        }
    }

}
