package com.application.blogging_application.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class codeCheck {
    public static int sumOfUnique(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        HashSet<Integer> A=new HashSet<>();
        HashSet<Integer> B=new HashSet<>();
        for (int num : nums) {
            boolean x = A.add(num);
            if (!x) {
                B.add(num);
            }
        }
        A.removeAll(B);
        System.out.println(A);
        for (Integer integer : A) {
            sum = sum + integer;
        }
        return sum;}

    public static void main(String[] args) {
        int[] a={1,1,1,1,1};
        System.out.println(sumOfUnique(a));
    }
}
