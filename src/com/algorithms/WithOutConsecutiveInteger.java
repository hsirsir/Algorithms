package com.algorithms;

/**
 * Created by 6estates on 31-May-17.
 */
public class WithOutConsecutiveInteger {
    public static void main(String[] args){
        System.out.println(Integer.parseInt("1101",2));
    }
    public int findIntegers(int num) {
        int[] flagPos = new int[32];
        //11111
        //10101
        for(int i = 0; i < 32;i++){
            flagPos[i] = num & (1 << i);
        }
        for(int i = 0; i < 32;i++){
            //找到一片连续的1
            if(flagPos[i] == 1){
                int startPos = i;
                while (true){
                    if((i + 1) == 31) break;
                    if(flagPos[i + 1] == 1){
                        i += 1;
                    }else{
                        break;
                    }
                }
                if(i > startPos){
                    int endPos = i;
                    int isZero = 1;
                    while(endPos >= startPos){
                        if(isZero % 2 == 0){
                            num = do0(num,endPos);
                        }
                        isZero += 1;
                        endPos -= 1;
                    }
                }
            }
        }
        return num;
    }
    /**
     *
     * @param i 要操作的数
     * @param pos 第几位
     * @return 把 i 的第pos 位变为0后的值
     */
    public  int do0(int i,int pos){
        int src= Integer.MAX_VALUE^(1<<(pos-1));
        return i&src;
    }

    /**
     *
     * @param i 要操作的数
     * @param pos 第几位
     * @return 把 i 的第pos 位变为1后的值
     */
    public int do1(int i,int pos){
        return i|(1<<pos-1);
    }
}
