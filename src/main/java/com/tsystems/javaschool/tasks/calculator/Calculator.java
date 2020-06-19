package com.tsystems.javaschool.tasks.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
        if(!checkStatement(statement)) return null;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        DecimalFormat df = new DecimalFormat("###.####");
        try {
            BigDecimal result = new BigDecimal(engine.eval(statement).toString());
            return (df.format(result).replaceAll(",","."));
        } catch (Exception e) {
            return null;
        }
    }

    private boolean checkStatement(String statement) {
        if(statement==null) return false;
        return !statement.contains(",")
                && !statement.contains("++")
                && !statement.contains("..")
                && !statement.contains("--")
                && !statement.contains("**")
                && !statement.contains("//");
    }

}
