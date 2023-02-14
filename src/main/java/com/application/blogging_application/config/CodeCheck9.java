package com.application.blogging_application.config;

import java.util.HashMap;

public class CodeCheck9 {
    public static void main(String[] args) {
        int s=0;
        int nums[]={1,3};
        int k=3;
        if(nums.length==1) {
            System.out.println(0);
        }
        if(Math.abs(nums[0]-nums[1])==k && nums.length==2){
            System.out.println(1);
        }
        else{
            System.out.println(034);
        }
        HashMap<Integer,Integer> A=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            A.put(nums[i],A.getOrDefault(nums[i],0)+1);
        }
        for (int i=0;i<nums.length;i++){
            s=s+A.getOrDefault(nums[i]+k,0);
        }
        System.out.println(s);
    }
}
