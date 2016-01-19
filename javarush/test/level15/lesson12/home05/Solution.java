package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution()
    {
    }
    public Solution(double time)
    {
    }
    public Solution(Integer age)
    {
    }


    private Solution(String name)
    {
    }
    private Solution(Double age)
    {
    }
     private Solution(char name)
    {
    }


    protected Solution(float age)
    {
    }
    protected Solution(int age)
    {
    }
    protected Solution(Character name)
    {
    }

    Solution(Exception e)
    {

    }
   Solution(Number n)
    {

    }
    Solution(Float n)
    {

    }

}

