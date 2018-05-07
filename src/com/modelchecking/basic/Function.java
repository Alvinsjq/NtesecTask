package com.modelchecking.basic;

import com.modelchecking.utils.NameUtils;

import java.util.ArrayList;


/**
 * Created by alvin on 2018/5/7.
 */
public class Function {

    public Type FunType;// function的类别

    public String FunName;// function的名字，比如是加还是高位报警，还是比较等；
    public int FunID;  // function的id
    public int PageNum;// function所在页

    public ArrayList<String> Input; //function的输入列
    public ArrayList<String> Param; //function的参数列
    public ArrayList<String> Output; //function的输出列，这些列的元素可以是一个id标记，也可以是一个数值，需要分别处理

    public String Input_datatype;
    public String Output_datatype;

    public Function() {
    }

    public Type getFunType() {
        return FunType;
    }



    public void setFunType(String funName) {
        NameUtils nu  = new NameUtils();
        FunType = nu.DeterType(funName);
    }

    public String getFunName() {
        return FunName;
    }

    public void setFunName(String funName) {
        FunName = funName;
    }

    public int getFunID() {
        return FunID;
    }

    public void setFunID(int funID) {
        FunID = funID;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }

    public ArrayList<String> getInput() {
        return Input;
    }

    public void setInput(ArrayList<String> input) {
        Input = input;
    }

    public ArrayList<String> getParam() {
        return Param;
    }

    public void setParam(ArrayList<String> param) {
        Param = param;
    }

    public ArrayList<String> getOutput() {
        return Output;
    }

    public void setOutput(ArrayList<String> output) {
        Output = output;
    }

    public String getInput_datatype() {
        return Input_datatype;
    }

    public void setdatatype(String Funcname) {
        NameUtils nameUtils = new NameUtils();
        String datatype[] = nameUtils.DataType(getFunName());
        Input_datatype = datatype[0];
        Output_datatype = datatype[1];

    }

    public String getOutput_datatype() {
        return Output_datatype;
    }


}
