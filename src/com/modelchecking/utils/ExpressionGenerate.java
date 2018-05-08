package com.modelchecking.utils;

import com.modelchecking.basic.Function;

/**
 * Created by alvin on 2018/5/8.
 */
public class ExpressionGenerate {

    /**
     * 根据功能块得到其正确的DEFINE和ASSIGN的表达式
     * 需要正确地声明输入输出，等式两边的参数
     * @param f
     * @return
     */
    public StringBuffer getExpression(Function f){
        StringBuffer expression = new StringBuffer();
        ExpressionDeclare vd = new ExpressionDeclare();
        String fname = f.getFunName();
        StringBuffer leftdec = vd.GetLeftDec(f);//得到等式左边
        StringBuffer rightexp = vd.GetRightExp(f);//得到等式右边
        expression.append(leftdec).append(" := ").append(rightexp).append("\n");
        return expression;
    }


    /**
     * 得到输出功能块的next值，也就是输出的变量声明
     * @param f 为输出功能块
     * @return
     */
    public StringBuffer getNextExpression(Function f){
        StringBuffer nextExpr = new StringBuffer();
        ExpressionDeclare exd = new ExpressionDeclare();
        nextExpr.append("\t").append("next(B").append(f.getFunID()).append("_0)")
                .append(" := ")
                .append(exd.GetOutputID(f))
                .append("\n");
        return nextExpr;
    }
}
