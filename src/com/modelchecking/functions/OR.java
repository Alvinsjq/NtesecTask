package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class OR {

    public StringBuffer OR = new StringBuffer();

    public StringBuffer _OR_(String z1,String z2){
        OR.append(z1).append(" | ").append(z2).append(";");
        return OR;
    }

    public StringBuffer getOR() {
        return OR;
    }

}
