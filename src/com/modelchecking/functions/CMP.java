package com.modelchecking.functions;

import java.util.ArrayList;

/**
 * Created by alvin on 2018/5/7.
 */
public class CMP {

    public StringBuffer CMP = new StringBuffer();
    public int Mode = 0;//比较的模式

    /**
     * 生成CMP代码
     * @param x1
     * @param x2
     * @return
     */
    public StringBuffer _CMP_(String x1,String x2){
        String modestring = getModeString(getMode());
        CMP.append(x1).append(" "+modestring+" ").append(x2).append(" ? TRUE : FALSE;");
        return CMP;
    }

    /**
     * 获取HLLMT的smv的代码模版
     * @return
     */
    public StringBuffer getCMP() {
        return CMP;
    }

    /**
     * 设置参数
     * @param mode
     */
    public void setMode(int mode) {
        Mode = mode;
    }

    public int getMode(){
        return Mode;
    }

    public String getModeString(int mode){
        switch (mode){
            case 0:
                return "=";
            case 1:
                return "!=";
            case 2:
                return ">=";
            case 3:
                return "<=";
            case 4:
                return ">";
            case 5:
                return "<";
        }
        return "=";
    }
}
