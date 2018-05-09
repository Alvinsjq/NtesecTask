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

            case "AO":
                return Type.Output;

            //可以继续添加其他的功能模块名
            case "DIV":
                return Type.Basic;
            case "AND":
                return Type.Basic;
            case "AND4":
                return Type.Basic;
            case "OR":
                return Type.Basic;
            case "OR4":
                return Type.Basic;
            case "NOT":
                return Type.Basic;
            case "XOR":
                return Type.Basic;
            case "DI":
                return Type.Input;
            case "ABS":
                return Type.Basic;
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

            //模拟计算
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

            case "DIV":
                datatype[0] = inter;
                datatype[1] = inter;
                break;

            //输入输出
            case "AI":
                datatype[0] = inter;
                datatype[1] = inter;
                break;
            case "AO":
                datatype[0] = inter;
                datatype[1] = inter;
                break;
            case "DO":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "DI":
                datatype[0] = bool;
                datatype[1] = bool;
                break;

            //逻辑操作
            case "AND":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "XOR":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "NOT":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "OR":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "AND4":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "OR4":
                datatype[0] = bool;
                datatype[1] = bool;
                break;
            case "ABS":
                datatype[0] = inter;
                datatype[1] = inter;
        }

        return datatype;
    }

}


