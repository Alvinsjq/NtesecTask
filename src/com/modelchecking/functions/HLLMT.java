package com.modelchecking.functions;

import java.util.ArrayList;

/**
 * Created by alvin on 2018/5/7.
 */
public class HLLMT {

    public StringBuffer HLLMT = new StringBuffer();

    /**
     * 生成HTTML代码
     * @param x
     * @param low
     * @param high
     * @return
     */
    public StringBuffer _HTTML_(String x,String high,String low){
        HLLMT.append("\n")
                .append("\t\tcase\n")
                .append("\t\t\t"+x+" >= "+low+" & "+x+" <= "+high+" : "+x+";\n")
                .append("\t\t\t"+x+" < "+low+" : "+low+";\n")
                .append("\t\t\t"+x+" > "+high+" : "+high+";\n")
                .append("\t\tesac;");

        return HLLMT;
    }

    /**
     * 获取HLLMT的smv的代码模版
     * @return
     */
    public StringBuffer getHLLMT() {
        return HLLMT;
    }

}
