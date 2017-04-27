package com.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6estates on 27-Apr-17.
 */
public class ThreeSumSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();

        return ls;
    }

    boolean isContained(List<List<Integer>> intList,List<Integer> targetList){
        boolean b = true;
        for(List<Integer> tmpList:intList){
            boolean b1 = true;
            for(Integer num:targetList){
                if(tmpList.contains(num)){

                }
            }
        }
        return b;
    }
}
