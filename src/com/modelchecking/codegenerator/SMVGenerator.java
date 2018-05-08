package com.modelchecking.codegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alvin on 2018/5/8.
 */
public class SMVGenerator {
    BufferedWriter bw = null;

    public void GenerateSmvFile(){

        GenerateSMV generateSMV = new GenerateSMV();
        StringBuffer modulebuffer = new StringBuffer();

        StringBuffer Name = generateSMV.GetModuleNameCode();
        StringBuffer Ivar = generateSMV.IVARGenerator(generateSMV.AllFunctions);
        StringBuffer Var = generateSMV.VARGenerator(generateSMV.AllFunctions);
        StringBuffer Define = generateSMV.DefineGenerator(generateSMV.AllFunctions);
        StringBuffer Assign = generateSMV.AssignGenerator(generateSMV.AllFunctions);

        modulebuffer.append(Name)
                    .append(Ivar)
                    .append(Var)
                    .append(Define)
                    .append(Assign);

        String smv = modulebuffer.toString();

        try {
            File file = new File("gen_smv/main.smv");
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);

            bw = new BufferedWriter(fw);
            bw.write(smv);
            System.out.println("生成smv文件！");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(bw!=null){
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}
