package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
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
      String str1 = "abcd";
      String str2 = "cadb";
      byte[] b1 = str1.getBytes();
      byte[] b2 = str2.getBytes();
      System.out.println(b1 == b2);
      Arrays.sort(b1);
      Arrays.sort(b2);
      System.out.println(b1 == b2);

    }
}
