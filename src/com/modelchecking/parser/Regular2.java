package com.modelchecking.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular2 {


    public static void main(String[] args) {
        boolean Isfound = false;
        String line = "In= B33-0 , 100f , 0f ,";
        String pattern = "In="; //返回In=

        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(line);
        Isfound = m.find();
        if(Isfound){
            System.out.println(pattern + " matches \"" + m.group(0) + "\" in \"" + line + "\"");
            System.out.println("start:" + m.start() + " end:" + m.end());
        }

        String pattern1 = " ,";
        p = Pattern.compile(pattern1);
        String[] s = p.split(line);
        System.out.println("split");
        for(String input : s){
            System.out.println(input);
            //输出
            // In= B33-0
            // 100f
            // 0f
        }
    }
}


