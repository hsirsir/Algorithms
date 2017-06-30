package com.algorithms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    /*// write your code here
        String str1 = "";
        System.out.println(str1.length());*/
       /* List<Integer> ls = new ArrayList<>();
        ls.add(new Integer(1));
        ls.add(new Integer(3));
        ls.add(new Integer(6));
        if(ls.contains(new Integer(1))){
            System.out.println(true);
        }else{
            System.out.println(false);
        }*/
      /* int m = 1;
       System.out.println(m << 3);
       System.out.println(8 >> 3);*/
      /*  String str1 = "abcd";
        String str2 = "cadb";
        byte[] b1 = str1.getBytes();
        byte[] b2 = str2.getBytes();
        System.out.println(str1.equals(str2));
        Arrays.sort(b1);
        Arrays.sort(b2);
        String orderStr1 = new String(b1);
        String orderStr2 = new String(b2);
        System.out.println(orderStr1.equals(orderStr2));*/
     /* Integer a1 = 20;
      Integer a2 = 20;
      Integer b1 = 150;
      Integer b2 = 150;
      System.out.println(a1 == a2);
      System.out.println(b1 == b2);*/
   /*  int[] arr1 = new int[]{1,0,3};
     int[] arr2 = new int[]{1,0,3};
     System.out.println(arr1 == arr2);*/
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      /*  Date startDate = new Date(1494565839380l);
        System.out.println("startDate = " + simpleDateFormat.format(startDate));
        Date endDate = new Date(1490976000000l);
        System.out.println("endDate = " + simpleDateFormat.format(endDate));
        System.out.println(Long.MAX_VALUE);
        Long maxLong = Long.MAX_VALUE;
        String longStr = maxLong.toString();
        System.out.println(longStr.length());
        System.out.println(Math.pow(10,15));
        Integer maxInt = Integer.MAX_VALUE;
        String intStr = maxInt.toString();
        System.out.println(intStr.length());*/
        /*System.out.println(Double.MAX_VALUE);
        Double maxDouble = Double.MAX_VALUE;
        String dString = maxDouble.toString();
        System.out.println(dString);
        Double tmpD = Math.pow(10,30);
        System.out.println(tmpD % 10.0);*/
        /*double tmpD = 50d;
        double tmpD2 = 1750d;
        double res = tmpD / tmpD2 * 100;
        int tmpInt = (int)res;
        System.out.println(tmpInt);*/
       /* System.out.println((-0.0001d) > (-0.01d));*/
  /*     String path = "/";
       String[] pathList = path.split("/a");
       System.out.println(pathList.length);
       for(int i = 0;i < pathList.length;i++){
           System.out.println(pathList[i]);
       }*/
 /* System.out.println(System.getProperty("java.version"));*/
//    System.out.println(Integer.toBinaryString(5));
        String str1 = "1_blog_03e0d0700102xcw9";
        byte[] strBytes = str1.getBytes();
        System.out.println(strBytes);
    }
}
