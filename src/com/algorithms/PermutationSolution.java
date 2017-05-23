package com.algorithms;

import java.util.*;

/**
 * Created by 6estates on 02-May-17.
 */
public class PermutationSolution {

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int pos1 = 0;
        int pos2 = s1.length();
        //设置s1的标志
        Map<Character, Integer> hashMap_s11 = buildFlagMap(s1);
        while (true){
            String subStr = s2.substring(pos1,pos2);
            Map<Character,Integer> hashMap_subStr = buildFlagMap(subStr);
            if(compareFlagMap(hashMap_s11,hashMap_subStr)) {
                return true;
            }
            pos1++;
            pos2++;
            if(pos2 > s2.length()) {
                return false;
            }
        }
    }

    private Map<Character, Integer> buildFlagMap(String s1) {
        HashMap<Character,Integer> hashMap_s1 = new HashMap<>();
        for(int i = 0;i < s1.length();i++){
            Integer char_count = hashMap_s1.remove(s1.charAt(i));
            if(char_count != null){
                char_count += 1;
                hashMap_s1.put(s1.charAt(i),char_count);
            }else{
                hashMap_s1.put(s1.charAt(i),1);
            }
        }
        return hashMap_s1;
    }

    public boolean compareFlagMap(Map<Character,Integer> map1, Map<Character,Integer> map2){
        Iterator<Character> keysIt1 = map1.keySet().iterator();
        if(map1.size() != map2.size()) return false;
        while (keysIt1.hasNext()){
            Character key1 = keysIt1.next();
            Integer val1 = map1.get(key1);
            Integer val2 = map2.get(key1);
            if (val2 == null) return false;
            if(val2.intValue() != val1.intValue()) return false;
        }
        return true;
    }
}
