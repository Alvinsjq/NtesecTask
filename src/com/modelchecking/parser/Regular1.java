package com.modelchecking.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular1 {


    public static void main(String[] args) {
        boolean Isfound = false;
        String line = "Func, HLLMT, 123:30, (1020,510), 54";
        String line1 = "In= B33-0 , 100f , 0f ,";
        String pattern = "Func"; //返回Func
        String pattern2 = "Func, [a-zA-Z]+,"; //返回Func, HLLMT,
        String pattern3 = "\\d+:"; //返回123
        String pattern4 = "\\), \\d+"; //返回), 54
        Pattern p = Pattern.compile(pattern4);
        Matcher m = p.matcher(line);
        Isfound = m.find();
        if(Isfound){
            // group(0)或group()将会返回整个匹配的字符串（完全匹配）；group(i)则会返回与分组i匹配的字符
            // 这个例子只有一个分组
            System.out.println(pattern + " matches \"" + m.group(0) + "\" in \"" + line + "\"");
            System.out.println("start:" + m.start() + " end:" + m.end());
        }
    }
}


