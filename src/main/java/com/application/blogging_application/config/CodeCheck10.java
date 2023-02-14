package com.application.blogging_application.config;

public class CodeCheck10 {
    public static void main(String[] args) {
        int c=0;
        String allowed="cad";
        String[] words={"cc","acd","b","ba","bac","bad","ac","d"};
        for(int i=0;i< words.length;i++){
            for(int j=0;j<words[i].length();j++){
                if(allowed.indexOf(words[i].charAt(j))==-1){
                    c++;
                    break;
                }
            }
        }
        System.out.println(words.length-c);
    }
}
