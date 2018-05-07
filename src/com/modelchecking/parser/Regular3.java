package com.modelchecking.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular3 {


    public static void main(String[] args) {
        boolean Isfound = false;
        String line = "Para= 1,1,0,";
        String line1 = "Para=";
        String pattern = "Para="; //返回In=

        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(line);
        Isfound = m.find();
        if(Isfound){
            System.out.println(pattern + " matches \"" + m.group(0) + "\" in \"" + line + "\"");
            System.out.println("start:" + m.start() + " end:" + m.end());
        }

        String pattern1 = ",";
        p = Pattern.compile(pattern1);
        String[] s = p.split(line);
        System.out.println("split");
        for(String input : s){
            System.out.println(input);
            //输出
            // Para= 1
            // 1
            // 0

            //或
            //Para=
        }
    }
}




