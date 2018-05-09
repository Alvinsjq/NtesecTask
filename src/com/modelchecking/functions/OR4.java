package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class OR4 {

    public StringBuffer OR4 = new StringBuffer();

    public StringBuffer _OR4_(String z1,String z2,String z3,String z4){
        OR4.append(z1).append(" | ").append(z2).append(" | ").append(z3).append(" | ").append(z4).append(";");
        return OR4;
    }

    public StringBuffer getOR4() {
        return OR4;
    }
}


