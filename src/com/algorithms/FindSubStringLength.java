package com.algorithms;
import java.util.HashMap;

/**
 * Created by hgh on 2017-04-14.
 */
public class FindSubStringLength {
    public static void main(String[] args){
        int[] resArrs = getMaxLenSubString("aaadbacoap");
        for(int i = 0;i<resArrs.length;i++){
            System.out.println(resArrs[i]);
        }
    }

    public static int[] getMaxLenSubString(String str){
        int[] resArr = new int[2];
        int maxLen = 0;
        int strLen = str.length();
        HashMap flagMap = null;
        int nextStart = 0;
        int firstPos = 0;
        for(int i = nextStart;i<str.length();i++){

            if((str.length() - i) <= maxLen){
                break;
            }
            flagMap = new HashMap();
            flagMap.put(str.charAt(i),1);
            for(int m = i+1;m<str.length();m++){
                if(flagMap.containsKey(str.charAt(m))){
                    nextStart++;
                    break;
                }else{
                    flagMap.put(str.charAt(m),1);
                    if((m - i) > maxLen){
                        firstPos = i;
                        maxLen = m - i;
                    }
                }
            }
        }
        resArr[0] = maxLen + 1;
        resArr[1] = firstPos + 1;
        return resArr;
    }

}
