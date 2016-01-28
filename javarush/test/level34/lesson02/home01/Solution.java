package com.javarush.test.level34.lesson02.home01;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
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
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
        System.out.println(summ("3+5"));
        System.out.println(diff("3-5"));
        System.out.println(div("8/3.56"));
    }

    public void recursion(final String expression, int countOperation) {


        //implement
    }

    public Solution() {
        //don't delete
    }

    public static double summ(String s) {
        String[] rez = s.split("\\+");
        return Double.parseDouble(rez[0]) + Double.parseDouble(rez[1]);
    }

    public static double diff(String s) {
        String[] rez = s.split("\\-");
        return Double.parseDouble(rez[0]) - Double.parseDouble(rez[1]);
    }

    public static double mult(String s) {
        String[] rez = s.split("\\*");
        return Double.parseDouble(rez[0]) * Double.parseDouble(rez[1]);
    }
     public static double div(String s) {
        String[] rez = s.split("/");
        return Double.parseDouble(rez[0]) / Double.parseDouble(rez[1]);
    }




}
