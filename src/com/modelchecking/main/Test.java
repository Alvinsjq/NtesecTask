package com.modelchecking.main;

import com.modelchecking.parser.ReadFiles;

import java.io.IOException;

/**
 * Created by alvin on 2018/5/7.
 */
public class Test {
   public static void main(String[] args){
       ReadFiles rf = new ReadFiles();
       try {
           rf.ReadFile("model/demo.txt");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
