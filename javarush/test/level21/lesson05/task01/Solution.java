package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
         if (n == null)
         {
             return false;
         }
        if (n.getClass() != this.getClass())
        {
            return false;
        }
         Solution s = (Solution) n;
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
        s.add(new Solution("Donald", "Duck"));

        System.out.println(s.contains(new Solution("Donald", "Duck")));

        Solution s1 = new Solution(null, null);
        Solution s2 = new Solution(null, null);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));
    }
}
