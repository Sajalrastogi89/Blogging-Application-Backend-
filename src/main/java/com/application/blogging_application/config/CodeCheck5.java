package com.application.blogging_application.config;

import java.util.HashMap;

public class CodeCheck5 {
    public static void main(String[] args) {
        String q="";
        String key="the quick brown fox jumps over the lazy dog";
        String message="vkbs bs t suepuv";
        HashMap<Character,Character> A=new HashMap<>(26);
        char x='a';
        for (int i=0;i<key.length();i++) {
            if(key.charAt(i)==' ' || A.containsKey(key.charAt(i))){
                continue;
            }
//            System.out.print(key.charAt(i)+" ");
//            System.out.println(x);
            A.put(key.charAt(i),x++);
        }
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==' '){
                q=q+' ';
                continue;
            }
            q=q+A.get(message.charAt(i));
        }
        System.out.println(q);
    }
}
