package com.algorithms;

import java.util.Arrays;

/**
 * Created by 6estates on 02-May-17.
 */
public class PermutationSolution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int pos1 = 0;
        int pos2 = s1.length();
        byte[] bytes1 = s1.getBytes();
        Arrays.sort(bytes1);
        String str1 = new String(bytes1);
        while (true){
            if(pos2 > s2.length()) return false;
            String subStr = s2.substring(pos1,pos2);
            byte[] bytes2 = subStr.getBytes();
            Arrays.sort(bytes2);
            String str2 = new String(bytes2);
            if(str1.equals(str2)){
                return true;
            }
            pos1++;
            pos2++;
        }
    }
}
