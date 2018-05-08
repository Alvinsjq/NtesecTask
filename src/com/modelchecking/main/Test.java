package com.modelchecking.main;

import com.modelchecking.codegenerator.SMVGenerator;
import com.modelchecking.parser.ReadFiles;
import org.eclipselabs.nusmvtools.nusmv4j.NuSMV4J;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary;
import static org.eclipselabs.nusmvtools.nusmv4j.NusmvLibraryUtil.toByteBuffer;
import java.io.IOException;

/**
 * Created by alvin on 2018/5/7.
 */
public class Test {
   public static void main(String[] args){
       ReadFiles rf = new ReadFiles();
       SMVGenerator smvgen = new SMVGenerator();
       try {
           rf.ReadFile("model/demo.txt");
           smvgen.GenerateSmvFile();
       } catch (IOException e) {
           e.printStackTrace();
       }

       NusmvLibrary nusmvLibrary = new NuSMV4J().getNusmvLibrary();

       nusmvLibrary.Cmd_CommandExecute(toByteBuffer("reset"));
       nusmvLibrary.Cmd_CommandExecute(toByteBuffer("read_model -i /Users/alvin/Documents/tools/NuSMVModelAdvisor_20121012/main.smv"));
       nusmvLibrary.Cmd_CommandExecute(toByteBuffer("flatten_hierarchy"));
       nusmvLibrary.Cmd_CommandExecute(toByteBuffer("encode_variables"));
       nusmvLibrary.Cmd_CommandExecute(toByteBuffer("build_model"));
       nusmvLibrary.Cmd_CommandExecute(toByteBuffer("check_ltlspec"));

   }
}
