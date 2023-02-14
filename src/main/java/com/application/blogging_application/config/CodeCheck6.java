package com.application.blogging_application.config;

public class CodeCheck6 {
    static boolean check(char a,char b,String order){
        if(order.indexOf(a)<=order.indexOf(b)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
       String words[] = {"hello","leetcode"};
       String order = "hlabcdefgijkmnopqrstuvwxyz";
       for(int i=0;i<words.length;i++){
           for(int j=0;j<words[i].length();j++){
               
           }
       }
    }
}
