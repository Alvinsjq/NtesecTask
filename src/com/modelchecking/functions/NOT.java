package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class NOT {

    public StringBuffer NOT = new StringBuffer();

    public StringBuffer _NOT_(String x){
        NOT.append("! ").append(x).append(";");
        return NOT;
    }

    public StringBuffer getNOT() {
        return NOT;
    }
}
