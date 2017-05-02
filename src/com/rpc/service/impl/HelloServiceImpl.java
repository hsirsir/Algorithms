package com.rpc.service.impl;

import com.rpc.service.HelloService;

/**
 * Created by 6estates on 02-May-17.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String input) {
        return input + "  wellcome!!!!!!!!!!!!";
    }
}
