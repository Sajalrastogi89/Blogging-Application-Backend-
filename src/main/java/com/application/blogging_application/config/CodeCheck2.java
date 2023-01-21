package com.application.blogging_application.config;

import java.util.HashMap;
import java.util.HashSet;

public class CodeCheck2 {
    static int count=0;
    public static void intersection(int[] arr1,int[] arr2){
        HashSet<Integer> h=new HashSet<>();
        for(int a:arr1){
            h.add(a);
        }
        for(int b:arr2){
            if(h.contains(b)){
                h.remove(b);
                count++;
            }
        }
        System.out.println(count);
    }


    public static void main(String[] args) {
        int[] arr1={1,3,2,4,5};
        int[] arr2={3,4,2,3,4,5};
        intersection(arr1,arr2);
    }
    HashMap<Integer,Integer> A=new HashMap<>();
}
