package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class ABS {
    public StringBuffer ABS = new StringBuffer();

    public int k = 1; //x的系数
    public int c = 0;  //输出偏置参数
    public StringBuffer _ABS_(String x){
        ABS.append("abs(").append(String.valueOf(getK())).append("*").append(x).append(" + ").append(String.valueOf(getC())).append(");");
        return ABS;
    }

    public StringBuffer getABS() {
        return ABS;
    }


    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
