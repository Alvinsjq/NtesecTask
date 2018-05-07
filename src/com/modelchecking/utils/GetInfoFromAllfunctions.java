package com.modelchecking.utils;

import com.modelchecking.basic.Function;
import com.modelchecking.basic.Type;

import java.util.ArrayList;

/**
 * Created by alvin on 2018/5/7.
 */
public class GetInfoFromAllfunctions {

    /**
     * 得到输入的声明，包括变量名和其数据类型声明
     * @param Allfunctions
     * @return
     */
    public ArrayList<String> GetInputVar(ArrayList<Function> Allfunctions){
        ArrayList<String> inputvars = new ArrayList<String>();
        for (Function f : Allfunctions) {
            if (f.getFunType() == Type.Input){
               String datatype =  f.getOutput_datatype();
               if(datatype.equals("boolean"))
                   inputvars.add("B"+f.getFunID()+" : boolean;\n");
               else if(datatype.equals("int"))
                   inputvars.add("B"+f.getFunID()+" : -10..10;\n");
            }
        }
        return inputvars;
    }


    /**
     * 得到输出变量的声明，包括变量名称以及其数据类型
     * 注意：
     * 在define中何时取-i取决于功能块类型，如果是输入输出的，简单都以没有-i的形式出现
     * 而对于basic与complex块都以输出的-i结尾来命名它的输入输出名字
     * @param Allfunctions
     * @return
     */
    public ArrayList<String> GetOutputVar(ArrayList<Function> Allfunctions){
        ArrayList<String> outputvars = new ArrayList<String>();
        for (Function f : Allfunctions) {
            if (f.getFunType() == Type.Output){
                String datatype =  f.getInput_datatype();
                if(datatype.equals("boolean"))
                    outputvars.add("B"+f.getFunID()+" : boolean;\n");
                else if(datatype.equals("int"))
                    outputvars.add("B"+f.getFunID()+" : -10..10;\n");
            }
        }
        return outputvars;
    }

}
