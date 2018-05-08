package com.modelchecking.utils;

import com.modelchecking.basic.Function;

import java.util.ArrayList;

/**
 * Created by alvin on 2018/5/8.
 */
public class VariablesDeclare {

    /**
     * 得到标准格式的输入字符串，这些字符串用来为指定功能块的输入参数进行参数声明或赋值
     * 输入的字符串可能是B12_0这种形式，也可能是一个特定的值
     * @param f
     * @return
     */
    public ArrayList<String> GetRightVariables(Function f){
        ArrayList<String> rightvars = new ArrayList<String>();
        for(String s : f.getInput()){
            if(s.charAt(0)=='B')
                //代表输入是其他功能块的输出
                s = s.replace('-','_');
            else if(s.charAt(s.length()-1)=='f')
                s = s.substring(0,s.length()-1);
            rightvars.add(s);
        }
        return rightvars;
    }
}
