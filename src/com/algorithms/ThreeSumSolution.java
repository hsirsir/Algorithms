package com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6estates on 27-Apr-17.
 */
public class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(nums[i]);
            for(int j = i + 1;j < nums.length;j++){
                tmpList.add(nums[j]);
                for (int k = j + 1; k < nums.length;k++){
                    tmpList.add(nums[k]);
                }
            }
            if(tmpList.size() == 3){
                if(!isContained(ls,tmpList)){
                    ls.add(tmpList);
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
