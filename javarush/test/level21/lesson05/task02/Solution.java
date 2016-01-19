package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Solution))
            return false;
        Solution s = (Solution) o;

        if (this.first == null && s.first == null && this.last == null && s.last == null)
                        {
                            return  true;
                        }

                if (this.first == null && s.first == null)
                {
                    return true && this.last.equals(s.last);
                }
                if (this.last == null && s.last == null)
                {
                    return this.first.equals(s.first) && true;
                }


                return this.first.equals(s.first) && this.last.equals(s.last);
    }
    public int hashCode() {
           int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (last != null ? last.hashCode() : 0);
            return result;
       }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        System.out.println(new Solution(new String("Mickey"), "Mouse").equals(new Solution("Mickey", "Mouse")));
    }
}
