package com.algorithms;

/**
 * Created by hgh on 2017-04-26.
 */
public class ReverseSolution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res;
    }
}