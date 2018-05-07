package com.modelchecking.parser;

import com.modelchecking.basic.Function;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by alvin on 2018/5/7.
 */
public class ReadFiles {
    ArrayList<Function> AllFunctions = new ArrayList<Function>();

    public void ReadFile(String filepath) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filepath)
        ));

        String line = null;
        boolean Isfun;
        boolean IsId;
        boolean IsPage;
        boolean IsIn;
        boolean IsParam;
        boolean IsOut;
        Pattern p;
        Matcher m;
        Function function = null;

        while ((line = br.readLine()) != null) {
//           System.out.println(line);

            String func = "Func, [a-zA-Z]+,";
            String id = "\\d+:";
            String page = "\\), \\d+";
            String In = "In=";
            String PtIn = " ,";//或者PtOut
            String Param = "Para=";
            String PtParam = ",";
            String Out = "Out=";

            p = Pattern.compile(func);
            m = p.matcher(line);
            Isfun = m.find();

            if (Isfun) {

                function = new Function();
                String funname = m.group(0).substring(6, m.group(0).length() - 1);
                System.out.println(funname);

                function.setFunName(funname);//为function属性赋值Name
                function.setFunType(funname);//为function属性赋值Type


                p = Pattern.compile(id);
                m = p.matcher(line);
                IsId = m.find();

                if (IsId)
                    function.setFunID(Integer.parseInt(m.group(0).substring(0,m.group(0).length()-1)));//为function属性赋值Id

                p = Pattern.compile(page);
                m = p.matcher(line);
                IsPage = m.find();

                if (IsPage)
                    function.setPageNum(Integer.parseInt(m.group(0).substring(3, m.group(0).length())));//为function属性赋值Page
            } else {
                p = Pattern.compile(In);
                m = p.matcher(line);
                IsIn = m.find();
                if (IsIn) {
                    p = Pattern.compile(PtIn);
                    String[] s = p.split(line);
                    ArrayList<String> Input = new ArrayList<String>();

                    for (int i = 0; i < s.length-1; i++) {
                        s[i] = s[i].trim();
                        if (i == 0)
                            Input.add(s[0].substring(4, s[i].length()));
                        else
                            Input.add(s[i]);
                    }
                    function.setInput(Input);//为function属性赋值Input
                } else {
                    p = Pattern.compile(Param);
                    m = p.matcher(line);
                    IsParam = m.find();
                    if (IsParam) {
                        p = Pattern.compile(PtParam);
                        String[] s = p.split(line);
                        ArrayList<String> Params = new ArrayList<String>();

                        for (int i = 0; i < s.length; i++) {
                            s[i] = s[i].trim();
                            if (i == 0) {
                                if (s[0].length() == 5) break; //没有参数则停止
                                Params.add(s[i].substring(6, s[i].length()));
                            } else
                                Params.add(s[i]);
                        }

                        function.setParam(Params);//为function属性赋值Params
                    } else {
                        p = Pattern.compile(Out);
                        m = p.matcher(line);
                        IsOut = m.find();
                        if (IsOut) {
                            p = Pattern.compile(PtIn);
                            String[] s = p.split(line);
                            ArrayList<String> Output = new ArrayList<String>();

                            for (int i = 0; i < s.length-1; i++) {
                                s[i] = s[i].trim();
                                if (i == 0)
                                    Output.add(s[i].substring(5, s[i].length()));
                                else
                                    Output.add(s[i]);
                            }
                            function.setOutput(Output);//为function属性赋值Output
                            function.setdatatype(function.getFunName());//为function属性赋值输入输出的数据类型
                            AllFunctions.add(function);//完成一个Func的赋值，将对象存进AllFunctions
                        }
                    }
                }
            }
        }
        br.close();
    }


    public ArrayList<Function> getAllFunctions() {
        return AllFunctions;
    }
}
