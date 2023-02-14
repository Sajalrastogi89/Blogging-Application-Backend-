package com.application.blogging_application.config;

import java.util.HashMap;
import java.util.HashSet;

public class CodeCheck8 {
    public static void main(String[] args) {
        int x=0;
        String s="";
        String[] words={"a"};
        if(words.length==1){
            System.out.println(1);
        }
        String[] A={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<Character,String> B=new HashMap<>();
        HashSet<String> C=new HashSet<>();
        for(char i='a';i<='z';i++){
            B.put(i,A[x++]);
        }
        for (String f:words) {
            for (int c=0;c<f.length();c++) {
               s=s+ B.get(f.charAt(c));
            }
            System.out.println(s);
            C.add(s);
            s="";
        }
        System.out.println(C.size());
    }
}
