package com.github.vansaurabh.grpc.server;

import com.github.vansaurabh.grpc.greeting.service.GreetServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC");

        Server server = ServerBuilder.forPort(50051)
                        .addService(new GreetServiceImpl())
                        .build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("Received ShutDown Request");
            server.shutdown();
            System.out.println("Server stopped successfully!!");
        }));
        server.awaitTermination();
    }
}
