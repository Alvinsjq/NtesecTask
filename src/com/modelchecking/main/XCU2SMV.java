package com.modelchecking.main;

import com.modelchecking.codegenerator.SMVGenerator;
import com.modelchecking.parser.ReadFiles;
import java.io.IOException;

/**
 * Created by alvin on 2018/5/7.
 */
public class XCU2SMV {
   public static void main(String[] args){
       ReadFiles rf = new ReadFiles();
       SMVGenerator smvgen = new SMVGenerator();
       if(args.length!=1){
           System.out.println("======Convert to model checking input file .SMV with following command:======");
           System.out.println(">> XCU2SMV [filepath..]");
       }else{
           String filename = args[0];
           try {
               rf.ReadFile(filename);
               smvgen.GenerateSmvFile(filename);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}

