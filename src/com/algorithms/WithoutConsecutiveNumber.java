package com.algorithms;

import java.util.HashMap;

/**
 * Created by 6estates on 31-May-17.
 */
public class WithoutConsecutiveNumber {
    public int RES = 0;
    public static int NUM_LEN = 0;
    public static int NUM = 0;
    public int findIntegers(int num) {
        if(num == 1) return 2;
        if(num == 0) return 1;
        NUM_LEN = Integer.toBinaryString(num).length();
        NUM = num;
        goNext("");
        return RES + 2;
    }

    public void goNext(String nowNumberStr){
        if(nowNumberStr == ""){
            goNext("0");
            goNext("1");
        }
        if(nowNumberStr .length() > 0){
            char headChar = nowNumberStr.charAt(0);
            if(nowNumberStr.length() < NUM_LEN){
                if(headChar != '0' && nowNumberStr.length() > 1){
                    RES += 1;
                }
                System.out.println(nowNumberStr);
            }
            if(nowNumberStr.length() == NUM_LEN) {
                int lastNum = Integer.parseInt(nowNumberStr,2);
                System.out.println(nowNumberStr);
                if (lastNum <= NUM && headChar != '0' && nowNumberStr.length() > 1) {
                   RES += 1;
                }
                return;
            }
            StringBuilder destStrBuilder = new StringBuilder();
            if (headChar == '0'){
                 destStrBuilder.append('0');
                destStrBuilder.append(nowNumberStr);
                goNext(destStrBuilder.toString());
                destStrBuilder = new StringBuilder();
                destStrBuilder.append('1');
                destStrBuilder.append(nowNumberStr);
                goNext(destStrBuilder.toString());
            }
            if(headChar == '1'){
                destStrBuilder.append('0');
                destStrBuilder.append(nowNumberStr);
                goNext(destStrBuilder.toString());
            }
        }
    }
}
