package com.modelchecking.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular4 {


    public static void main(String[] args) {
        boolean Isfound = false;
        String line = "Out= 0 , 12 , 1 ,";
        String line1 = "Out=";
        String pattern = "Out="; //返回Out=

        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(line);
        Isfound = m.find();
        if(Isfound){
            System.out.println(pattern + " matches \"" + m.group(0) + "\" in \"" + line + "\"");
            System.out.println("start:" + m.start() + " end:" + m.end());
        }

        String pattern1 = " ,";
        p = Pattern.compile(pattern1);
        String[] s = p.split(line1);
        System.out.println("split");
        for(String input : s){
            System.out.println(input);
            //输出
            //Out= 0
            // 12
            // 1

            //或输出 （line1的话）
            //Out=
        }
    }
}


