package com.application.blogging_application.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeCheck7 {
    public static void main(String[] args) {

ArrayList<Integer> A=new ArrayList<>();
//A.add(4);
//        A.add(5);
//        A.add(6);
//        A.add(7);
//        A.add(8);
//        A.add(9);
        int[] A1={6,14,15,26,31,36,38,41,42,45};
      for(int y=0;y<A1.length;y++){
          A.add(A1[y]);
      }
        int c;
        int g=-2;
        int diff=5;
        int d=0;
        ArrayList<Integer> B=new ArrayList<>();
        //Traversing in loop
      for(int i=0;i<A.size();i++){
          g=-2;
          B.clear();
            c=A.get(i);
            //Adding precalculated value in ArrayList
            while(c<=A.get(A.size()-1) && B.size()<=3){
                B.add(c);
                c=c+diff;
           }
            //Checking ArrayList that it must contain at least one pair of triplet
            if(B.size()<3)
                break;
            for(int j=0;j< B.size();j++){
                  if(!A.contains(B.get(j))){
                      if(g>0){
                      d=d+g;}
                      g=-2;

                  }
                  else{
                      System.out.println(B.get(j));
                  g++;
                  if(g>0)
                  {
                  break;
                  }
                  }

            }
          if(g>0){
              d=d+g;
          System.out.println(d);

          }

        }
            System.out.println(d);

           }
        }