package com.modelchecking.utils;

import com.modelchecking.basic.Function;
import com.modelchecking.functions.*;

import java.util.ArrayList;

/**
 * 这个类是处理DEFINE和ASSIGN的核心类，它主要是生成等式左边的声明以及等式右边的表达式
 * 而表达式的生成需要设置功能块的输入、参数等；
 * Created by alvin on 2018/5/8.
 */
public class ExpressionDeclare {
    /**
     * 得到define下面表达式左侧的变量名字
     * @param f
     * @return
     */
    public StringBuffer GetLeftDec(Function f){
        StringBuffer leftexpression = new StringBuffer();
        leftexpression.append("B").append(f.FunID).append("_0");
        return leftexpression;
    }

    /**
     * 得到等式右边的代码生成结果
     * @param f
     * @return
     */
    public StringBuffer GetRightExp(Function f){
        StringBuffer rightexp = new StringBuffer();

        //得到输入变量名
        VariablesDeclare variablesDeclare = new VariablesDeclare();
        ArrayList<String> varlist = variablesDeclare.GetRightVariables(f);

        //得到参数值
        Params params = new Params();
        ArrayList<Integer> parameters = params.GetParams(f.getParam());

        //设置功能块的各属性并得到生成代码
        switch (f.getFunName()){
            case "SUM":
                SUM sum = new SUM();
                sum.setK1(parameters.get(0));
                sum.setK2(parameters.get(1));
                sum.setC(parameters.get(2));
                sum._SUM_(varlist.get(0),varlist.get(1));
                rightexp.append(sum.getSUM());
                break;
            case "HLLMT":
                HLLMT hllmt = new HLLMT();
                hllmt._HTTML_(varlist.get(0),varlist.get(1),varlist.get(2));
                rightexp.append(hllmt.getHLLMT());
                break;
            case "CMP":
                CMP cmp = new CMP();
                cmp.setMode(parameters.get(0));
                cmp._CMP_(varlist.get(0),varlist.get(1));
                rightexp.append(cmp.getCMP());
                break;
            case "MULT":
                MULT mult = new MULT();
                mult.setK1(parameters.get(0));
                mult.setK2(parameters.get(1));
                mult.setC1(parameters.get(2));
                mult.setC2(parameters.get(3));
                mult._MULT_(varlist.get(0),varlist.get(1));
                rightexp.append(mult.getMULT());
                break;

            case "DIV":
                DIV div = new DIV();
                div.setK1(parameters.get(0));
                div.setK2(parameters.get(1));
                div.setC1(parameters.get(2));
                div.setC2(parameters.get(3));
                div._DIV_(varlist.get(0),varlist.get(1));
                rightexp.append(div.getDIV());
                break;

            case "AND":
                AND and = new AND();
                and._AND_(varlist.get(0),varlist.get(1));
                rightexp.append(and.getAND());
                break;
            case "AND4":
                AND4 and4 = new AND4();
                and4._AND4_(varlist.get(0),varlist.get(1),varlist.get(2),varlist.get(3));
                rightexp.append(and4.getAND4());
                break;
            case "NOT":
                NOT not = new NOT();
                not._NOT_(varlist.get(0));
                rightexp.append(not.getNOT());
                break;
            case "OR":
                OR or = new OR();
                or._OR_(varlist.get(0),varlist.get(1));
                rightexp.append(or.getOR());
                break;
            case "OR4":
                OR4 or4 = new OR4();
                or4._OR4_(varlist.get(0),varlist.get(1),varlist.get(2),varlist.get(3));
                rightexp.append(or4.getOR4());
                break;
            case "XOR":
                XOR xor = new XOR();
                xor._XOR_(varlist.get(0),varlist.get(1));
                rightexp.append(xor.getXOR());
                break;
            //...可以扩展更多的功能块
            case "ABS":
                ABS abs = new ABS();
                abs.setK(parameters.get(0));
                abs.setC(parameters.get(1));
                abs._ABS_(varlist.get(0));
                rightexp.append(abs.getABS());
                break;
        }

        return rightexp;
    }

    /**
     * 输出功能块的输入参数值
     * @param f
     * @return
     */
    public StringBuffer GetOutputID(Function f){
        StringBuffer outid = new StringBuffer();
        VariablesDeclare variablesDeclare = new VariablesDeclare();
        ArrayList<String> inputlist = variablesDeclare.GetRightVariables(f);
        for (String s: inputlist)
            outid.append(s).append(";\n");
        return outid;
    }

}
