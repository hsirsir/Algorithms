package com.algorithms;

import java.util.Arrays;

/**
 * Created by 6estates on 26-Apr-17.
 */
public class NearestPalindromicSolution {

    public static void main(String[] args){
        NearestPalindromicSolution nearestPalindromicSolution = new NearestPalindromicSolution();
        System.out.println(nearestPalindromicSolution.nearestPalindromic("99999"));
    }
    /**
     *
     * @param n
     *
     * @return
     */
    public String nearestPalindromic(String n) {
        if(n.length() == 1){
          Integer selfInt = Integer.parseInt(n);
          Integer targeInt = 0;
          if(selfInt > 0){
              targeInt = selfInt - 1;
              return  targeInt.toString();
          }else{
              return  targeInt.toString();
          }
        }
        StringBuffer stringBuffer = new StringBuffer();
        Long upInt = 0l;
        Long mediumInt = 0l;
        Long downInt = 0l;
        Long selfInt = Long.parseLong(n);
        Long  palindromeInt = 0l;
        String tmpStr = null;
        if(n.length() % 2 == 0){
            tmpStr =  n.substring(0,(n.length() / 2));
            StringBuffer tmpBuf = new StringBuffer();
            tmpBuf.append(tmpStr);
            Long tmpInt = Long.parseLong(tmpStr) + 1;
            StringBuffer upBuf = new StringBuffer(tmpInt.toString());
            String upStr = upBuf.toString();
            tmpInt = Long.parseLong(tmpStr) - 1;
            StringBuffer downBuf = new StringBuffer();
            if(tmpInt > 0){
                downBuf.append(tmpInt.toString());
            }
            String downStr = downBuf.toString();
            for(int i = tmpStr.length();i>0;i--){
                tmpBuf.append(tmpStr.charAt(i-1));
            }
            for(int i = downStr.length();i>0;i--){
                downBuf.append(downStr.charAt(i-1));
            }
            for(int i = upStr.length();i>0;i--){
                upBuf.append(upStr.charAt(i-1));
            }
            System.out.println(upBuf.toString());
            mediumInt = Long.parseLong(tmpBuf.toString());
            System.out.println(mediumInt);
            if(upBuf.length() > n.length()){
                String str1 = upBuf.substring(0,upBuf.length() - 2) + "1";
                upBuf = new StringBuffer(str1);
            }
            upInt = Long.parseLong(upBuf.toString());
            System.out.println(upInt);
            if(downBuf.length() != n.length() ){
                downBuf.append("9");
            }
            downInt = Long.parseLong(downBuf.toString());
            System.out.println(downInt);
            Long tmpCha = selfInt;
            Long[] tmpInts = new Long[]{mediumInt,downInt,upInt};
            Arrays.sort(tmpInts);
            Long targetInt = mediumInt;
            for(int i = 0;i<tmpInts.length;i++){
                System.out.println("================ ");
                if(Math.abs(tmpInts[i] - selfInt) < tmpCha){
                    if(!tmpInts[i].equals(selfInt)) {
                        System.out.println("------= "+tmpInts[i]);
                        tmpCha = Math.abs(tmpInts[i] - selfInt);
                        targetInt = tmpInts[i];
                    }
                }
            }
            return targetInt.toString();
        }else{
            tmpStr =  n.substring(0,(n.length() / 2) + 1);
            StringBuffer tmpBuf = new StringBuffer();
            tmpBuf.append(tmpStr);
            Long tmpInt = Long.parseLong(tmpStr) + 1;
            StringBuffer upBuf = new StringBuffer(tmpInt.toString());
            String upStr = upBuf.toString();
            tmpInt = Long.parseLong(tmpStr) - 1;
            StringBuffer downBuf = new StringBuffer(tmpInt.toString());
            String downStr = downBuf.toString();
            for(int i = tmpStr.length()-1;i>0;i--){
                tmpBuf.append(tmpStr.charAt(i-1));
            }
            for(int i = upStr.length()-1;i>0;i--){
                upBuf.append(upStr.charAt(i-1));
            }
            for(int i = downStr.length()-1;i>0;i--){
                downBuf.append(downStr.charAt(i-1));
            }
            mediumInt = Long.parseLong(tmpBuf.toString());
            System.out.println(mediumInt);
            if(upBuf.length() > n.length()){
                String str1 = upBuf.substring(0,upBuf.length() - 2) + "1";
                upBuf = new StringBuffer(str1);
            }
            upInt = Long.parseLong(upBuf.toString());
            System.out.println(upInt);
            if(downBuf.length() != n.length() ){
                downBuf.append("9");
            }
            downInt = Long.parseLong(downBuf.toString());
            System.out.println(downInt);
            Long tmpCha = selfInt;
            Long[] tmpInts = new Long[]{mediumInt,downInt,upInt};
            Arrays.sort(tmpInts);
            Long targetInt = mediumInt;
            for(int i = 0;i<tmpInts.length;i++){
                System.out.println("======================"+tmpInts[i]);
                if(Math.abs(tmpInts[i] - selfInt) < tmpCha){
                    if(!tmpInts[i].equals(selfInt)) {
                        tmpCha = Math.abs(tmpInts[i] - selfInt);
                        targetInt = tmpInts[i];
                    }
                }
            }
            return targetInt.toString();
        }

    }
}