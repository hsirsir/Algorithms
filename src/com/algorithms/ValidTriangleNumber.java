package com.algorithms;

import java.util.Arrays;

/**
 * Created by 6estates on 14-Jun-17.
 */
public class ValidTriangleNumber {
    /*public static void main(String[] args){
        int[] nums = new int[]{2,2,3,4};
        ValidTriangleNumber soltion = new ValidTriangleNumber();
        int res = soltion.triangleNumber(nums);
        System.out.println(res);
    }*/
    public int triangleNumber(int[] nums) {
        int res = 0;
        int endPos = nums.length - 1;
        Arrays.sort(nums);
        int pos1 = 0;//最短边
        int pos2 = 1;//边长中间
        int pos3 = 2;//最长边
        while (true){
            //1,3,5,5,7,20,23
         if(pos1 > (endPos - 2)) break;
         if(pos3 <= endPos  && nums[pos1] + nums[pos2] > nums[pos3]){
             res += 1;
             pos3 += 1;
             continue;
         }else{
            if((endPos - 1) > pos2){
                pos2 += 1;
                pos3 = pos2 + 1;
                continue;
            }
            pos1 += 1;
            pos2 = pos1 + 1;
            pos3 = pos2 + 1;
         }
        }
        return res;
    }
}
