package com.modelchecking.functions;

/**
 * Created by alvin on 2018/5/9.
 */
public class XOR {
    public StringBuffer XOR = new StringBuffer();

    public StringBuffer _XOR_(String z1,String z2){
        XOR.append(z1).append(" xor ").append(z2).append(";");
        return XOR;
    }

    public StringBuffer getXOR() {
        return XOR;
    }
}
