import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;

import com.dqs.grpc.User;
import com.dqs.grpc.userGrpc;

import static com.dqs.grpc.userGrpc.newBlockingStub;

public class gRPCClient {

 public static void main(String[] args){
     
     ManagedChannel channel =  ManagedChannelBuilder.forAddress("192.168.50.125", 9091).usePlaintext().build();

     //stub from proto file

     userGrpc.userBlockingStub stub =  userGrpc.newBlockingStub(channel);

     User.LoginRequest request = User.LoginRequest.newBuilder().setUsername("Hello").setPassword("Hello").build();

     User.APIResponse response = stub.login(request);

     System.out.println("Response : "+ response.getResponseMessage());

 }

}