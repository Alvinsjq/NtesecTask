package com.modelchecking.codegenerator;

import com.modelchecking.basic.Function;
import com.modelchecking.basic.Type;
import com.modelchecking.parser.ReadFiles;
import com.modelchecking.utils.ExpressionDeclare;
import com.modelchecking.utils.ExpressionGenerate;
import com.modelchecking.utils.GetInfoFromAllfunctions;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by alvin on 2018/5/7.
 */
public class GenerateSMV {

    public ArrayList<Function> AllFunctions;

    public GenerateSMV(String filepath) {
        //构造函数初始化得到所有的功能计算模块
        GetAllFunctions(filepath);
    }

    public void GetAllFunctions(String filepath){
        ReadFiles rf = new ReadFiles();
        try {
            rf.ReadFile(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AllFunctions = rf.getAllFunctions();
    }

    /**
     * 这里负责smv模型名字的生成逻辑
     * @param
     */
    public StringBuffer GetModuleNameCode(){
        StringBuffer MODULE = new StringBuffer();
        String filestart = "MODULE main\n";
        MODULE.append(filestart).append("\n");
        return MODULE;
    }

    /**
     * 这里生成SMV模型中的IVAR块的代码
     * 主要是输入变量的声明生成，定义为B+id的形式
     * 例如输入func的id号为3，则声明B3
     * @param AllFunctions
     */
    public StringBuffer IVARGenerator(ArrayList<Function> AllFunctions){
        StringBuffer IVAR = new StringBuffer();
        GetInfoFromAllfunctions getInfoFromAllfunctions = new GetInfoFromAllfunctions();
        ArrayList<String> ivar = getInfoFromAllfunctions.GetInputVar(AllFunctions);

        IVAR.append("IVAR\n");
        for (String s : ivar)
            IVAR.append("\t").append(s);
        IVAR.append("\n");
        return IVAR;
    }

    /**
     * 这里生成SMV模型中的VAR块的代码
     * 这里的变量声明主要是输出变量声明
     * @param AllFunctions
     */
    public StringBuffer VARGenerator(ArrayList<Function> AllFunctions){
        StringBuffer VAR = new StringBuffer();
        GetInfoFromAllfunctions getInfoFromAllfunctions = new GetInfoFromAllfunctions();
        ArrayList<String> var = getInfoFromAllfunctions.GetOutputVar(AllFunctions);

        VAR.append("VAR\n");
        for(String s : var)
            VAR.append("\t").append(s);
        VAR.append("\n");
        return VAR;
    }

    /**
     * 这里生成SMV模型中的Define块的代码
     * 主要是该页的计算逻辑
     * @param AllFunctions
     */
    public StringBuffer DefineGenerator(ArrayList<Function> AllFunctions){
        StringBuffer DEFINE = new StringBuffer();
        GetInfoFromAllfunctions getInfoFromAllfunctions = new GetInfoFromAllfunctions();
        ArrayList<Function> FunctionsNeedDefined = getInfoFromAllfunctions.GetComputeFunctions(AllFunctions);
        ExpressionGenerate expressionGenerate = new ExpressionGenerate();
        DEFINE.append("DEFINE\n");
        for (Function fd : FunctionsNeedDefined)
            DEFINE.append("\t").append(expressionGenerate.getExpression(fd)); //分别生成等式
        DEFINE.append("\n");
        return DEFINE;
    }

    /**
     * 这里生成SMV模型中的Assign块的代码
     * 主要做的是初始化输出以及将计算得到的值作为输出的下一个状态
     * @param AllFunctions
     */
    public StringBuffer AssignGenerator(ArrayList<Function> AllFunctions){
        StringBuffer ASSIGN = new StringBuffer();
        GetInfoFromAllfunctions getInfoFromAllfunctions = new GetInfoFromAllfunctions();
        ArrayList<String> init = getInfoFromAllfunctions.GetInitVar(AllFunctions);

        ASSIGN.append("ASSIGN\n");
        for (String s : init)
            ASSIGN.append("\t").append(s);
        ExpressionGenerate exg = new ExpressionGenerate();
        for(Function f : AllFunctions){
            if(f.getFunType()== Type.Output){
                ASSIGN.append(exg.getNextExpression(f));
            }
        }

        return ASSIGN;
    }

    /**
     * 性质生成
     * @param AllFunctions
     */
    public StringBuffer LTLSPEC(ArrayList<Function> AllFunctions){
        StringBuffer LTLSPEC = new StringBuffer();


        return LTLSPEC;
    }


}
