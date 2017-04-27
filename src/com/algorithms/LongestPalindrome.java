package com.algorithms;

/**
 * Created by hgh on 2017-04-26.
 */
public class LongestPalindrome {
    /**
     * Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("fdgd");
        return stringBuffer.toString();
    }

    public boolean isPalindrome(String s){
        if(s == "") return false;
        if(s.length() == 1) return true;
        int startIndex = 0;
        int endIndex = s.length() - 1;
        while (true){
            if(startIndex == endIndex || endIndex < startIndex) return true;
            if(s.charAt(startIndex) != s.charAt(endIndex)) return false;
            startIndex++;
            endIndex--;
        }
    }

}
