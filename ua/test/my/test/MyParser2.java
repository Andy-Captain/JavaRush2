package com.ua.test.my.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParser2 {
    public static void main(String[] args) {
        MyParser2 solution = new MyParser2();
        //  solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recursion("2^8", 0); //expected output 0.5 6
        solution.recursion("sin(3)+5", 0); //expected output 0.5 6
        // solution.recursion("sin(2*((-5+1.5*4))+28)", 0); //expected output 0.5 6
        //        System.out.println(Solution.eval("- 5 + 1.5 * 4 / 6"));
        //  System.out.println(Solution.eval("-2+2/5*3"));
        //System.out.println(Solution.eval("(8-5)-(5+15*4)"));
        // System.out.println(Solution.eval("-2.5*(-0.5+15.2*4)+28"));
        // System.out.println(Solution.eval("sin(2*(-5+1.5*4)+28)"));
        // System.out.println(Solution.eval("sin(2)"));
        //      System.out.println(Solution.eval("2+3"));
       // System.out.println(solution.checkIsInt("23564545454545454545454.1"));
//        System.out.println(solution.checkIsDouble("-23055454545454545454.45"));

    }

    public void recursion(final String expression, int countOperation) {
        String parseStr = expression;
        //DecimalFormat df = new DecimalFormat("#.##");
        if (parseStr.charAt(0) == '-') {
            parseStr = 0 + parseStr;
        }
        parseStr = parseStr.replaceAll("\\(-", "(0-");
        System.out.println(parseStr);
        String a = "";
        String b = "";
        String operand = "";
        String value="";
        boolean bb = true;
        boolean cc = true;
        for (int i = 0; i < parseStr.length(); i++) {
            char c = parseStr.charAt(i);
            if (Character.isDigit(c) && bb) {

                // a = "";

                while (i < parseStr.length() && (Character.isDigit(parseStr.charAt(i)) || parseStr.charAt(i) == '.'))
                    a += parseStr.charAt(i++);
                --i;
                bb = false;
            }
            if (isOperand(c) && cc) {
                if (c == 's' || c == 'c' || c == 't') {
                    //sin cos tg
                    while (i < parseStr.length() && (Character.isLetter(parseStr.charAt(i)) && parseStr.charAt(i) != '(' && parseStr.charAt(i) != ')'))
                     operand += parseStr.charAt(i++);
                    --i;
                    cc = false;

                                                                        /// cut to next )

                    b = parseStr.substring(i + 1, parseStr.length()).replaceFirst("\\(","").replaceFirst("\\)","");

                    break;
                } else {
                    operand = String.valueOf(c);
                    b = parseStr.substring(i + 1, parseStr.length());
                    break;

                }
            }
        }

        Double first = null;
        Double last = null;
        Double rezult = null;
        if (!a.isEmpty()) {
            first = Double.parseDouble(a);
        }



        if (checkIsDouble(b)||checkIsInt(b)) {

            last = Double.parseDouble(b);       //calculate

            switch (operand) {
                case "+":
                    rezult = Math.rint(100.0 * (first + last)) / 100;
                    countOperation++;
                    break;
                case "-":
                    rezult = Math.rint(100.0 * (first - last)) / 100;
                    countOperation++;
                    break;
                case "*":
                    rezult = Math.rint(100.0 * (first * last)) / 100;
                    countOperation++;
                    break;
                case "/":
                    rezult = Math.rint(100.0 * (first / last)) / 100;

                    countOperation++;
                    break;
                case "^":
                    rezult = Math.rint(100.0 * (Math.pow(first, last))) / 100;
                    countOperation++;
                    break;
                case "sin":
                    rezult = Math.rint(100.0 * (Math.sin(Math.toRadians(last)))) / 100;
                    countOperation++;
                    break;
                case "cos":
                    rezult = Math.rint(100.0 * (Math.cos(Math.toRadians(last)))) / 100;
                    countOperation++;
                    break;
                case "tg":
                    rezult = Math.rint(100.0 * (Math.tan(Math.toRadians(last)))) / 100;
                    countOperation++;
                    break;


            }

             value = String.valueOf(rezult);
                   if (value.endsWith(".0")||value.endsWith(".00"))
                   {
                       String[] split = value.split(".");
                       value = split[0];

                   }


                   System.out.println("!!!"+value +" "+countOperation);



        }


//        else{      if (!checkIsInt(b) && b.length() > 0){

//            recursion(b,countOperation);
           // return;
        }
//
//                  }




   // }


    private boolean isOperand(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == 's' || c == 'c' || c == 't';
    }

    private boolean checkIsDouble(String s) {

//        Pattern p = Pattern.compile("^[\\+\\-]{0,1}[0-9]+[\\.\\,]{1}[0-9]+$");
        Pattern p = Pattern.compile("^[\\+\\-]{0,1}[0-9]+[\\.\\,][0-9][0-9]");
        Matcher m = p.matcher(s);
        return m.matches();
    }
    private boolean checkIsInt(String s){

//        Pattern p = Pattern.compile("^[\\+\\-][0-9][0-9]");
        Pattern p = Pattern.compile("[\\+\\-]*[0-9]+");
        Matcher m = p.matcher(s);
        return m.matches();
    }

}
