package com.rpc.client;

import com.rpc.service.HelloService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * Created by 6estates on 02-May-17.
 */
public class Client {
    public static void main(String[] args){
        HelloService helloService = getProxy(HelloService.class,"127.0.0.1",9080);
        System.out.println(helloService.sayHello("6Estates"));
    }

    public static  <T> T getProxy(Class<T> interfaceClass,String host,int port){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host,port);
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(method.getName());
                output.writeObject(method.getParameterTypes());
                output.writeObject(args);
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                return input.readObject();
            }
        });
    }
}
