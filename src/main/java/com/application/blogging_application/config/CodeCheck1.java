package com.application.blogging_application.config;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashSet;

public class CodeCheck1 {
    public static void union(int[] arr1, int[] arr2){
        HashSet<Integer> h=new HashSet<>();
        for (int j : arr1) {
            h.add(j);
        }
        for(int i:arr2){
            h.add(i);
        }
        System.out.println(h);
    }
    public static void main(String[] args) {
        int[] arr1 ={1,3,2,4,2};
        int[] arr2 ={4,5,3,5,2};
        union(arr1,arr2);
    }
}
