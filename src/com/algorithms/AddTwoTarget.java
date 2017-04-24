package com.algorithms;

/**
 * Created by hgh on 2017-04-13.
 */
public class AddTwoTarget {
    public static void main(String[] args){
        int[] arrs = new int[]{1,6,11,9,9,23,56,78,23,78,77};
        int[] resArrs = getTargetSum(arrs,18);
        if(resArrs == null){
            System.out.println("no indices");
        }else{
            for(int i = 0;i<resArrs.length;i++){
                System.out.println(resArrs[i]);
            }
        }
    }

    public static int[] getTargetSum(int arrs[],int targetNumber){
        int[] tmpArrs = new int[2];
        boolean b = false;
        for(int i = 0;i<arrs.length - 1;i++){
            tmpArrs[0] = i;
            b = false;
            for(int m = i+1;m<arrs.length;m++){
                if((arrs[i] + arrs[m]) == targetNumber){
                    b = true;
                    tmpArrs[1] = m;
                    break;
                }
            }
            if(b){
                break;
            }
        }
        if(b == true){
            return tmpArrs;
        }else{
            return  null;
        }

    }

}
