package com.algorithms;

/**
 * Created by hgh on 2017-04-26.
 */
public class LongestPalindrome {
    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String targetStr = "aaaodfghgfdoll";
        String palindromeStr = longestPalindrome.longestPalindrome(targetStr);
        System.out.println(palindromeStr);
    }
    /**
     * Input: "babad"

     Output: "bab"

     Note: "aba" is also a valid answer.
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String palindromeStr = "";
        for(int i = 0;i < s.length();i++){
            String subStr = "";
            for(int m = i + 1 ;m <= s.length();m++){
                subStr = s.substring(i,m);
                if(isPalindrome(subStr)){
                    if(subStr.length() > palindromeStr.length()){
                        palindromeStr = subStr;
                    }
                }
            }
        }
        return palindromeStr;
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
