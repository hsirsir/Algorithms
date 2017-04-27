package com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6estates on 27-Apr-17.
 */
public class ThreeSumSolution {
    public static void main(String[] args){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSumSolution threeSumSolution = new ThreeSumSolution();
        System.out.println(threeSumSolution.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                for (int k = j + 1; k < nums.length;k++){
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[k]);
                    int res = nums[i] + nums[j] + nums[k];
                    if(!isContained(ls,tmpList) && res == 0){
                        ls.add(tmpList);
                    }
                }
            }
        }
        return ls;
    }

    boolean isContained(List<List<Integer>> intList,List<Integer> targetList){
        int len = targetList.size();
        for(List<Integer> tmpList:intList){
            int flagInt = 0;
            for(Integer num:targetList){
                if(tmpList.contains(num)){
                    flagInt += 1;
                }
            }
            if(flagInt == len){
                return true;
            }
        }
        return false;
    }
}
