package com.algorithms;

/**
 * Created by hgh on 2017-04-14.
 */
public class MedianTwoSortedArray {
    public static void main(String args[]){

    }
    public int findTwoArrayMedian(int[] aarr,int astart,int aend,int[] barr,int bstart,int bend,int k){
        int res = 0;
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        if((m + n)%2 == 0){

        }
        return res;
    }
    public int findKth(int[] aarr,int astart,int aend,int[] barr,int bstart,int bend,int k){
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        if(m > n){
            return findKth(barr,bstart,bend,aarr,astart,aend,k);
        }
        if(k == 1){
            return aarr[astart];
        }
        int partA = Math.min(k / 2,m);
        int partB = k - partA;
        if(aarr[astart + partA - 1] < barr[bstart + partB - 1]){
            return findKth(aarr,astart + partA,aend,barr,bstart,bend,k - partA);
        }else if(aarr[astart + partA - 1] == barr[bstart + partB - 1]){
            return aarr[astart + partA - 1];
        }else{
            return  findKth(aarr,astart,aend,barr,bstart + partB,bend,k - partB);
        }
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
