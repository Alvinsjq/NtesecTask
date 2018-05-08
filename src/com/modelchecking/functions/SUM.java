package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/7.
 */
public class SUM {

    public StringBuffer SUM = new StringBuffer();
    public int k1 = 1; //x1的系数
    public int k2 = 1; //x2的系数
    public int c = 0;  //输出偏置参数


    /**
     * 生成CMP代码
     * @param x1
     * @param x2
     * @return
     */
    public StringBuffer _SUM_(String x1,String x2){
        SUM.append(String.valueOf(getK1())).append("*").append(x1)
                .append(" + ").append(String.valueOf(getK2())).append("*").append(x2)
                .append(" + ").append(String.valueOf(getC()));
        return SUM;
    }

    /**
     * 获取SUM的smv的代码模版
     * @return
     */
    public StringBuffer getSUM() {
        return SUM;
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

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
