package com.algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by 6estates on 02-May-17.
 */
public class PermutationSolutionFinal {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int pos1 = 0;
        int pos2 = s1.length();
        //设置s1的标志
        int[] s1Arr1 = buildFlag(s1);
        while (true){
            String subStr = s2.substring(pos1,pos2);
            int[] subArr = buildFlag(subStr);
            if(compareIntArr(s1Arr1,subArr)) return true;
            pos1++;
            pos2++;
            if(pos2 > s2.length()) return false;
        }
    }

    private int[] buildFlag(String s1) {
        int[] s1Arr = new int[200];
        for(int i = 0;i< s1Arr.length;i++){
            s1Arr[i] = 0;
        }
        for(int i = 0;i<s1.length();i++){
            int index = s1.charAt(i);
            s1Arr[index] += 1;
        }
        return s1Arr;
    }

    boolean compareIntArr(int[] arr1,int[] arr2){
        if(arr1.length != arr2.length) return false;
        for(int i = 0;i < arr1.length;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }


}
