package com.mv.javacert;

public class RecursiveDigitSum {

    private static String getSumString(String p) {
        while(p.length() > 1) {                       
            Long sum = 
                p.codePoints().mapToLong(c -> Long.valueOf(String.valueOf((char) c))).reduce(0, Long::sum);
            
            p = sum.toString();    
        }
        return p;
    }
}
