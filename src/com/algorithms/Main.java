package com.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	/*// write your code here
        String str1 = "";
        System.out.println(str1.length());*/
        List<Integer> ls = new ArrayList<>();
        ls.add(new Integer(1));
        ls.add(new Integer(3));
        ls.add(new Integer(6));
        if(ls.contains(new Integer(1))){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

    }
}
