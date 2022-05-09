import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import com.dqs.grpc.User;
import com.dqs.grpc.userGrpc;

import static com.dqs.grpc.userGrpc.newBlockingStub;

public class gRPCClient {

    public static void main(String[] args) throws InterruptedException {

        // https://www.rfc-editor.org/rfc/rfc7540#section-3.5
        // 连接起始报文：0x505249202a20485454502f322e300d0a0d0a534d0d0a0d0a

        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.8.128", 9091).usePlaintext().build();

        // stub from proto file

        userGrpc.userBlockingStub stub = userGrpc.newBlockingStub(channel);

        while (true) {

            Thread.sleep(3000);

            User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("Hello").setPassword("Hello")
                    .build();

            User.APIResponse response = stub.login(request);

            System.out.println("Response : " + response.getResponseMessage());
        }

    }

}