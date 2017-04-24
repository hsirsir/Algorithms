package com.algorithms;

/**
 * Created by hgh on 2017-04-14.
 */
public class MedianTwoSortedArray {
    public static void main(String args[]){

    }
    public static void getMedianNumber(int numbers1[],int numbers2[]){
        int len1 = numbers1.length;
        int len2 = numbers2.length;
        int[] tmpArrs1 = numbers1;
        int[] tmpArrs2 = numbers2;
        int[] tmpArr = null;
        int tmpLen = 0;
        while(true){
            int tmp  = 0;
            int tmp1 = 0;
            if(len1 > len2){
                tmp = tmpArrs1[len1/2];
                tmpArr = tmpArrs2;
                tmpLen = len2;
            }else{
                tmp = tmpArrs2[len2/2];
                tmpArr = tmpArrs1;
                tmpLen = len1;
            }
            while(true){
                tmp1 = tmpArr[tmpLen / 2];
                if(tmp1 > tmp){

                }else{

                }
            }
        }

    }
}
