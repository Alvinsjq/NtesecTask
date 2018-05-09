package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class AND {

    public StringBuffer AND = new StringBuffer();

    public StringBuffer _AND_(String z1,String z2){
        AND.append(z1).append(" & ").append(z2).append(";");
        return AND;
    }

    public StringBuffer getAND() {
        return AND;
    }
}
