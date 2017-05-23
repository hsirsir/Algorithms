package com.rpc.server;

import com.rpc.service.HelloService;
import com.rpc.service.impl.HelloServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 6estates on 02-May-17.
 */
public class Server {
    public static void main(String[] args){
        HelloService service = new HelloServiceImpl();
        try {
            ServerSocket serverSocket = new ServerSocket(9080);
            while(true){
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                            String methodName = input.readUTF();
                            Class<?>[] parameterTypes = (Class<?>[])input.readObject();
                            Object[] arguments = (Object[])input.readObject();
                            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                            Method method = service.getClass().getMethod(methodName,parameterTypes);
                            Object result = method.invoke(service,arguments);
                            output.writeObject(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
