package com.modelchecking.utils;

import java.util.ArrayList;

/**
 * Created by alvin on 2018/5/8.
 */
public class Params {

    /**
     * 处理参数变量，获得参数并转为integer型的list
     * 这里的参数为功能块参数赋值做准备
     * @param params
     * @return
     */
    public ArrayList<Integer> GetParams(ArrayList<String> params){
        ArrayList<Integer> paramslist = new ArrayList<Integer>();

        for(int i=0;i<params.size();i++){
            String p = params.get(i);
            char[] pc = p.toCharArray();
            if(pc[pc.length-1]!='f')
                paramslist.add(Integer.parseInt(p));
            else
                paramslist.add(Integer.parseInt(p.substring(0,p.length()-1)));
        }
        return paramslist;
    }

}
