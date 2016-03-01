package com.ua.test.my.test;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParser3 {

    public static void main(String[] args) {
        MyParser3 solution = new MyParser3();
//            solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recursion("sin(2)", 0); //expected output 0.5 6
//        System.out.println(solution.checkIsDouble("-44444444444444444444444444444444444444.03"));
        // solution.recursion("sin(2*((-5+1.5*4))+28)", 0); //expected output 0.5 6
        //        System.out.println(Solution.eval("- 5 + 1.5 * 4 / 6"));
        //  System.out.println(Solution.eval("-2+2/5*3"));
        //System.out.println(Solution.eval("(8-5)-(5+15*4)"));
//        solution.recursion("-2.5*(-0.5+15.2*4)+28",0);
        // System.out.println(Solution.eval("sin(2*(-5+1.5*4)+28)"));
        // System.out.println(Solution.eval("sin(2)"));
        //      System.out.println(Solution.eval("2+3"));
//          System.out.println(MyParser3.eval("sin(1)"));
        /////////////////////
        String s = "sin(2*(-5+1.5*4)+28)";
//                 String s = "sin(2*(-5+1.5*4)+28)";
//    System.out.print(s + " expected output 0.5 6 actually ");
//    solution.recursion(s, 0);
//    s = "tan(45)";
//    System.out.print(s + " expected output 1 1 actually ");
//    solution.recursion(s, 0);
//    s = "tan(-45)";
//    System.out.print(s + " expected output -1 2 actually ");
//    solution.recursion(s, 0);
//    s = "0.305";
//    System.out.print(s + " expected output 0.3 0 actually ");
//    solution.recursion(s, 0);
//    s = "0.3051";
//    System.out.print(s + " expected output 0.31 0 actually ");
//    solution.recursion(s, 0);
//        s = "(0.3051)";
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recursion(s, 0);
//    s = "1+(1+(1+1)*(1+1))*(1+1)+1";
//    System.out.print(s + " expected output 12 8 actually ");
//    solution.recursion(s, 0);
//    s = "tan(44+sin(89-cos(180)^2))";
//    System.out.print(s + " expected output 1 6 actually ");
//    solution.recursion(s, 0);
//    s = "-2+(-2+(-2)-2*(2+2))";
//    System.out.print(s + " expected output -14 8 actually ");
//    solution.recursion(s, 0);
//    s = "sin(80+(2+(1+1))*(1+1)+2)";
//    System.out.print(s + " expected output 1 7 actually ");
//    solution.recursion(s, 0);
//    s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
//    System.out.print(s + " expected output 6 11 actually ");
//    solution.recursion(s, 0);
//    s = "2^10+2^(5+5)";
//    System.out.print(s + " expected output 2048 4 actually ");
//    solution.recursion(s, 0);
//    s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
//    System.out.print(s + " expected output 72.96 8 actually ");
//    solution.recursion(s, 0);
//    s = "0.000025+0.000012";
//    System.out.print(s + " expected output 0 1 actually ");
//    solution.recursion(s, 0);
//    s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
//    System.out.print(s + " expected output -3 16 actually ");
//    solution.recursion(s, 0);
//    s = "cos(3 + 19*3)";
//    System.out.print(s + " expected output 0.5 3 actually ");
//    solution.recursion(s, 0);
//    s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
//    System.out.print(s + " expected output 8302231.36 14 actually ");
//    solution.recursion(s, 0);
//    s = "(-1 + (-2))";
//    System.out.print(s + " expected output -3 3 actually ");
//    solution.recursion(s, 0);
//    s = "-sin(2*(-5+1.5*4)+28)";
//    System.out.print(s + " expected output -0.5 7 actually ");
//    solution.recursion(s, 0);
//    s = "sin(100)-sin(100)";
//    System.out.print(s + " expected output 0 3 actually ");
//    solution.recursion(s, 0);
//    s = "-(-22+22*2)";
//    System.out.print(s + " expected output -22 4 actually ");
//    solution.recursion(s, 0);
//    s = "-2^(-2)";                                                      //fall
//    System.out.print(s + " expected output -0.25 3 actually ");
//    solution.recursion(s, 0);
//    s = "-(-2^(-2))+2+(-(-2^(-2)))";                                        //fall
//    System.out.print(s + " expected output 2.5 10 actually ");
//    solution.recursion(s, 0);
//    s = "(-2)*(-2)";                                                          //  fall
//    System.out.print(s + " expected output 4 3 actually ");
//    solution.recursion(s, 0);
        s = "(-2)/(-2)";                                                            //fall
        System.out.print(s + " expected output 1 3 actually ");
        solution.recursion(s, 0);
//    s = "sin(-30)";
//    System.out.print(s + " expected output -0.5 2 actually ");
//    solution.recursion(s, 0);
//    s = "cos(-30)";
//    System.out.print(s + " expected output 0.87 2 actually ");
//    solution.recursion(s, 0);
//    s = "tan(-30)";
//    System.out.print(s + " expected output -0.58 2 actually ");
//    solution.recursion(s, 0);
//    s = "2+8*(9/4-1.5)^(1+1)";
//    System.out.print(s + " expected output 6.5 6 actually ");
//    solution.recursion(s, 0);
//    s = "0.005 ";
//    System.out.print(s + " expected output 0.01 0 actually ");
//    solution.recursion(s, 0);
//    s = "0.0049 ";
//    System.out.print(s + " expected output 0 0 actually ");
//    solution.recursion(s, 0);
//    s = "0+0.304";
//    System.out.print(s + " expected output 0.3 1 actually ");
//    solution.recursion(s, 0);

    }

    public void recursion(final String expression, int countOperation) {
        String exp = expression.replaceAll(" ", "");
        int firstBracket = 0;
        int lastBracket = 0;
        int operation = countOperation;
        String leftVal = "";
        String rightVal = "";
        Rezult rezult;
//        if (exp.startsWith("-") && !checkIsDouble(exp)) {          ////!!!
//            exp = 0 + exp;
//        }
        if (exp.startsWith("-") && checkIsDouble(exp)) {          ////!!!
            operation++;
        }
        if (exp.contains("(-")) {
            exp = exp.replaceAll("\\(-", "(0-");
        }
        if (checkIsDouble(exp)) {

            double d = Double.parseDouble(exp);
            d = (Math.rint(100.0 * d) / 100);
            exp = String.valueOf(d);
        }
        //  System.out.println("exp = "+exp);
        if (exp.contains("(")) {
            char[] chars = exp.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (firstBracket != 0 && lastBracket != 0) {
                    break;
                }

                if (chars[i] == '(')    // находим индексы выражения в скобках
                {

                    firstBracket = i;

                    for (int j = i + 1; j < chars.length; j++) {
                        if (chars[j] == '(') {
                            break;
                        }
                        if (chars[j] == ')') {

                            lastBracket = j;

                            break;
                        }
                    }
                }
            }
        }
        if (!exp.contains("(")) {
            rezult = calculate(exp, operation);
            operation = rezult.getCount();


            exp = leftVal + checkResult(rezult.getStr()) + rightVal;
            exp = checkExpression(exp);

        }

        if (lastBracket != 0) {
            String rexExp = exp.substring(firstBracket, lastBracket + 1);

            leftVal = exp.substring(0, firstBracket);
            rightVal = exp.substring(lastBracket + 1, exp.length());


            if (leftVal.endsWith("sin") || leftVal.endsWith("cos") || leftVal.endsWith("tan")) {
                String func = leftVal.substring(firstBracket - 3, firstBracket);
                leftVal = leftVal.substring(0, firstBracket - 3);
                rezult = calculate(func + rexExp, operation);
                operation = rezult.getCount();

                exp = leftVal + checkResult(rezult.getStr()) + rightVal;
                exp = checkExpression(exp);

            } else {

                rezult = calculate(rexExp, operation);
                operation = rezult.getCount();
                exp = leftVal + checkResult(rezult.getStr()) + rightVal;
                exp = checkExpression(exp);
            }

        }


        if (checkIsDouble(exp)) {

            double d = Double.parseDouble(exp);
            d = (Math.rint(100.0 * d) / 100);
            exp = String.valueOf(d);

            String finalExp = String.valueOf(exp);
            if (finalExp.endsWith(".0") || finalExp.endsWith(".00")) {

                finalExp = finalExp.replace(".0", "");

            }


            System.out.println(finalExp + " " + operation);


        }
        if (!checkIsDouble(exp)) {
            recursion(exp, operation);

        }


        //implement


    }

    private String checkExpression(String s) {
        if (s.contains("+-")) {
            s = s.replaceAll("\\+-", "-");
        }
        if (s.contains("--")) {
            s = s.replaceAll("--", "+");
        }
        return s;

    }

    private String checkResult(String s) {
        if (s.startsWith("-") && !checkIsDouble(s)) {
            s = 0 + s;
        }
        return s;
    }

    private boolean checkIsDouble(String s) {
        Pattern p = Pattern.compile("[\\-]*[\\d]+[\\.\\,][0-9]+");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private boolean checkIsInt(String s) {
        Pattern p = Pattern.compile("[\\+\\-]*[0-9]+");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private Rezult calculate(String s, int countOperation) {

        Rezult rezult = new Rezult();


        if (s.charAt(0) == '-') {
            s = 0 + s;
        }

        s = s.replaceAll("\\(-", "(0-");
        s = s.replaceAll("sin", "s");
        s = s.replaceAll("cos", "c");
        s = s.replaceAll("tan", "t");

        LinkedList<Double> st = new LinkedList<Double>(); // сюда наваливают цифры
        LinkedList<Character> op = new LinkedList<Character>(); // сюда опрераторы и st и op в порядке поступления
        for (int i = 0; i < s.length(); i++) { // парсим строку с выражением и вычисляем
            char c = s.charAt(i);
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(') {

                    countOperation = processOperator(st, op.removeLast(), countOperation);   //

                }
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c)) {

                    countOperation = processOperator(st, op.removeLast(), countOperation);    //

                }
                op.add(c);
            } else {
                String operand = "";

                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.'))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty())
            countOperation = processOperator(st, op.removeLast(), countOperation);
        rezult.setCount(countOperation);
        rezult.setStr(String.valueOf(st.get(0)));


        return rezult;
    }

    private class Rezult {
        String str;
        int count;

        private Rezult() {

        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    private boolean isOperator(char c) { // возвращяем тру если один из символов ниже
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == 's' || c == 'c' || c == 't';
    }


    private int priority(char op) {
        switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
            case 's':
            case 'c':
            case 't':
                return 1;

            case '+':
            case '-':
                return 2;
            case '*':
            case '/':

                return 3;
            case '^':
                return 4;

            default:
                return -1;
        }
    }


    static int processOperator(LinkedList<Double> st, char op, int operation) {
        double r = 0;
        double l = 0;

        if (op != 's' && op != 'c' && op != 't') {
            r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
            l = st.removeLast(); // также
        } else {
            r = st.removeLast();
        }
        switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case '+':
                st.add(Math.rint(100.0 * (l + r)) / 100);
                operation++;
                break;
            case '-':
                st.add(Math.rint(100.0 * (l - r)) / 100);
                operation++;
                break;
            case '*':
                st.add(Math.rint(100.0 * (l * r)) / 100);
                operation++;
                break;
            case '/':
                st.add(Math.rint(100.0 * (l / r)) / 100);
                operation++;
                break;
            case '^':
                st.add(Math.rint(100.0 * (Math.pow(l, r))) / 100);
                operation++;
                break;
            case 's':
                st.add(Math.rint(100.0 * (Math.sin(Math.toRadians(r)))) / 100);
                operation++;
                break;
            case 'c':
                st.add(Math.rint(100.0 * (Math.cos(Math.toRadians(r)))) / 100);
                operation++;
                break;
            case 't':
                st.add(Math.rint(100.0 * (Math.tan(Math.toRadians(r)))) / 100);
                operation++;
                break;

        }
        return operation;
    }


}
