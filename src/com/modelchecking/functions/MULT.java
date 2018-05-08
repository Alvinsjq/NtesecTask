package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/8.
 */
public class MULT {
    public StringBuffer MULT = new StringBuffer();
    public int k1 = 1; //x1的系数
    public int k2 = 1; //x2的系数
    public int c1 = 0;  //输出偏置参数
    public int c2 = 0;  //输出偏置参数

    public StringBuffer _MULT_(String x1,String x2){
        MULT.append(String.valueOf("("+getK1())).append("*").append(x1).append(" + ").append(getC1())
            .append(") * (").append(getK2()).append("*").append(x2).append(" + ").append(getC2())
                .append(");");
        return MULT;
    }

    public int getK1() {
        return k1;
    }

    public void setK1(int k1) {
        this.k1 = k1;
    }

    public int getK2() {
        return k2;
    }

    public void setK2(int k2) {
        this.k2 = k2;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public StringBuffer getMULT() {
        return MULT;
    }
}
