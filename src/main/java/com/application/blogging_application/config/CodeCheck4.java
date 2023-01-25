package com.application.blogging_application.config;

import java.util.HashMap;
import java.util.Map;

public class CodeCheck4 {
    static int sum=0;
    public static void numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> A = new HashMap<>();
        for (int num : nums) {
            A.put(num, A.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> c : A.entrySet()) {
            int x = c.getValue();
            if (x > 1) {
                sum = sum + x * (x - 1) / 2;
            }

        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        numIdenticalPairs(arr);
    }
}
