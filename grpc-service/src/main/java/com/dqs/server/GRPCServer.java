package com.dqs.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import com.dqs.service.UserService;

public class GRPCServer {

    public static void main(String args[]) throws IOException, InterruptedException {

        Server server = NettyServerBuilder.forAddress(new InetSocketAddress("192.168.8.128", 9091)).addService(new UserService()).build();

        server.start();

        System.out.println("Server started on " + server.getPort());

        server.awaitTermination();

    }
}
