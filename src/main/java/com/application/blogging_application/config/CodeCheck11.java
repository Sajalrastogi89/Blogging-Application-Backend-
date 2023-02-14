package com.application.blogging_application.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CodeCheck11 {
    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        HashSet<Character> B=new HashSet<>();
        HashMap<Integer,HashSet<Character>> A=new HashMap<>();
        int c=0;
        for(int i=1;i<rings.length();i+=2){
            B=A.getOrDefault((int)rings.charAt(i),new HashSet<>());
            B.add(rings.charAt(i-1));
            A.put((int)rings.charAt(i),B);
        }
        for(Map.Entry<Integer,HashSet<Character>> s:A.entrySet()){
            if(s.getValue().size()==3){
                c++;
            }
        }
        System.out.println(A);
        System.out.println(c);
    }
}
