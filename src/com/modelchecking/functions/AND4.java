package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class AND4 {

    public StringBuffer AND4 = new StringBuffer();

    public StringBuffer _AND4_(String z1,String z2,String z3,String z4){
        AND4.append(z1).append(" & ").append(z2).append(" & ").append(z3).append(" & ").append(z4).append(";");
        return AND4;
    }

    public StringBuffer getAND4() {
        return AND4;
    }
}
