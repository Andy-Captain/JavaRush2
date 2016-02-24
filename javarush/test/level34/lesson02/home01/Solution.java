package com.javarush.test.level34.lesson02.home01;

import java.util.LinkedList;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -,
возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        // solution.recursion("sin(2*((-5+1.5*4))+28)", 0); //expected output 0.5 6
//        System.out.println(Solution.eval("- 5 + 1.5 * 4 / 6"));
        //  System.out.println(Solution.eval("-2+2/5*3"));
        //System.out.println(Solution.eval("(8-5)-(5+15*4)"));
       // System.out.println(Solution.eval("-2.5*(-0.5+15.2*4)+28"));
      // System.out.println(Solution.eval("sin(2*(-5+1.5*4)+28)"));
      // System.out.println(Solution.eval("sin(2)"));
      System.out.println(Solution.eval("2+3"));

    }

    public void recursion(final String expression, int countOperation) {
        char[] chars = expression.toCharArray();
        int firstBracket = 0;
        int lastBracket = 0;
        for (int i = 0; i < chars.length; i++) {

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
        System.out.println(firstBracket + " " + lastBracket);

        //implement
    }

    //    public double rezultSimpleExpression(String exp)    // -5+1.5*4/6
//    {
//        double rez = 0;
//        while(exp.contains("*")){
//
//
//
//
//
//
//        }
//
//
//
//    }
//    static boolean isDelim(char c) { // тру если пробел
//        return c == ' ';
//    }

    static boolean isOperator(char c) { // возвращяем тру если один из символов ниже
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == 's' || c == 'c' || c == 't';
    }


    static int priority(char op) {
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


    static void processOperator(LinkedList<Double> st, char op) {
        double r = 0;
        double l = 0;
        if (op != 's' || op != 'c' || op != 't') {
            r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
            l = st.removeLast(); // также
        } else {
            r = st.removeLast();
        }
        switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '^':
                st.add(Math.pow(l, r));
                break;
            case 's':
                st.add(Math.sin(Math.toRadians(r)));
                break;
            case 'c':
                st.add(Math.cos(Math.toRadians(r)));
                break;
            case 't':
                st.add(Math.tan(Math.toRadians(r)));
                break;

        }
    }


    public static double eval(String s) {
        if (s.charAt(0) == '-') {
            s = 0 + s;
        }

        s = s.replaceAll("\\(-", "(0-");
        s = s.replaceAll("sin","s");
        s = s.replaceAll("cos","c");
        s = s.replaceAll("tan","t");
        System.out.println(s);
        LinkedList<Double> st = new LinkedList<Double>(); // сюда наваливают цифры
        LinkedList<Character> op = new LinkedList<Character>(); // сюда опрераторы и st и op в порядке поступления
        for (int i = 0; i < s.length(); i++) { // парсим строку с выражением и вычисляем
            char c = s.charAt(i);
//            if (isDelim(c))
//                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st, op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";

                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) =='.'))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);  // возврат результата
    }

    public Solution() {
        //don't delete
    }
}
