package com.algorithms;

/**
 * Created by 6estates on 26-Apr-17.
 */
public class NearestPalindromicSolution {

    public static void main(String[] args){
        NearestPalindromicSolution nearestPalindromicSolution = new NearestPalindromicSolution();
        System.out.println(nearestPalindromicSolution.nearestPalindromic("2222"));
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
        int upInt = 0;
        int mediumInt = 0;
        int downInt = 0;
        int selfInt = Integer.parseInt(n);
        int  palindromeInt = 0;
        String tmpStr = null;
        if(n.length() % 2 == 0){
            tmpStr =  n.substring(0,(n.length() / 2));
            StringBuffer tmpBuf = new StringBuffer();
            tmpBuf.append(tmpStr);
            Integer tmpInt = Integer.parseInt(tmpStr) + 1;
            StringBuffer upBuf = new StringBuffer(tmpInt.toString());
            String upStr = upBuf.toString();
            tmpInt = Integer.parseInt(tmpStr) - 1;
            StringBuffer downBuf = new StringBuffer(tmpInt.toString());
            String downStr = downBuf.toString();
            for(int i = tmpStr.length();i>0;i--){
                tmpBuf.append(tmpStr.charAt(i-1));
                upBuf.append(upStr.charAt(i-1));
                downBuf.append(downStr.charAt(i-1));
            }
            mediumInt = Integer.parseInt(tmpBuf.toString());
            System.out.println(mediumInt);
            upInt = Integer.parseInt(upBuf.toString());
            System.out.println(upInt);
            downInt = Integer.parseInt(downBuf.toString());
            System.out.println(downInt);
            int tmpCha = selfInt;
            int[] tmpInts = new int[]{mediumInt,downInt,upInt};
            Integer targetInt = mediumInt;
            for(int i = 0;i<tmpInts.length;i++){
                System.out.println(Math.abs(tmpInts[i] - selfInt));
                if(Math.abs(tmpInts[i] - selfInt) < tmpCha){
                    if(tmpInts[i] != selfInt) {
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
            Integer tmpInt = Integer.parseInt(tmpStr) + 1;
            StringBuffer upBuf = new StringBuffer(tmpInt.toString());
            String upStr = upBuf.toString();
            tmpInt = Integer.parseInt(tmpStr) - 1;
            StringBuffer downBuf = new StringBuffer(tmpInt.toString());
            String downStr = downBuf.toString();
            for(int i = tmpStr.length()-1;i>0;i--){
                tmpBuf.append(tmpStr.charAt(i-1));
                upBuf.append(upStr.charAt(i-1));
                downBuf.append(downStr.charAt(i-1));
            }
            mediumInt = Integer.parseInt(tmpBuf.toString());
            System.out.println(mediumInt);
            upInt = Integer.parseInt(upBuf.toString());
            System.out.println(upInt);
            downInt = Integer.parseInt(downBuf.toString());
            System.out.println(downInt);
            int tmpCha = selfInt;
            int[] tmpInts = new int[]{mediumInt,downInt,upInt};
            Integer targetInt = mediumInt;
            for(int i = 0;i<tmpInts.length;i++){
                if(Math.abs(tmpInts[i] - selfInt) < tmpCha){
                    if(tmpInts[i] != selfInt) {
                        tmpCha = Math.abs(tmpInts[i] - selfInt);
                        targetInt = tmpInts[i];
                    }
                }
            }
            return targetInt.toString();
        }

    }
}