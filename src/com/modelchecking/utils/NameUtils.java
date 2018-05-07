package com.modelchecking.utils;

import com.modelchecking.basic.Type;

/**
 * Created by alvin on 2018/5/7.
 */
public class NameUtils {


    /**
     * 根据功能块的名字确定其类别
     * @param funcname
     * @return 基本模块、复杂模块、输入模块、输出模块
     */
    public Type DeterType(String funcname){

        switch (funcname){
            case "SUM":
                return Type.Basic;

            case "Multi":
                return Type.Basic;

            case "HLLMT":
                return Type.Complex;

            case "CMP":
                return Type.Complex;

            case "AI":
                return Type.Input;

            case "DO":
                return Type.Output;

            //可以继续添加其他的功能模块名
        }

        return Type.Basic;

    }

    /**
     * 得到一个功能块的输入输出的数据类型
     * @param function
     * @return
     */
    public String[] DataType(String function){
        String[] datatype = new String[2];
        String bool = "boolean";
        String inter = "int";
        switch (function){
            case "SUM":
                datatype[0] = inter;
                datatype[1] = inter;
                break;

            case "Multi":
                datatype[0] = inter;
                datatype[1] = inter;
                break;

            case "HLLMT":
                datatype[0] = inter;
                datatype[1] = inter;
                break;

            case "CMP":
                datatype[0] = inter;
                datatype[1] = bool;
                break;

            case "AI":
                datatype[0] = inter;
                datatype[1] = inter;
                break;

            case "DO":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
        }

        return datatype;
    }

}


