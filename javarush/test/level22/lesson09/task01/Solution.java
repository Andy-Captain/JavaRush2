package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args)  {

        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
              BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine())))
              {
                String s;
                  ArrayList<String> wordList = new ArrayList<>();


               while ((s= reader2.readLine()) != null)
               {
                  String [] wordSplit = s.split(" ");
                   for (String s1 : wordSplit) {
                        wordList.add(s1.trim());



                   }
               }

                  for (int i = 0; i < wordList.size(); i++)
                  {
                      for (int j = 0; j < wordList.size(); j++)
                      {

                          if (wordList.get(i)==null || wordList.get(j)==null) continue;
                          String s1 = wordList.get(i);
                          String s2Rev = new StringBuilder(wordList.get(j)).reverse().toString();
                          if (s2Rev.equals(s1) && i != j)
                          {
                              Pair p = new Pair();
                              p.first = s1;
                              p.second = new StringBuilder(s1).reverse().toString();;
                              result.add(p);
                              wordList.set(i,null);
                              wordList.set(j,null);
                          }

                      }


                  }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

        @Override
        public boolean equals(Object thats) {

            if (thats == null)
            {
                return false;
            }
            if (thats instanceof Pair) {
                Pair that = (Pair) thats;


                if (this.first.equals(that.first) && this.second.equals(that.second)) {
                    return true;
                }
                if (this.first.equals(that.second) && this.second.equals(that.first)) {
                    return true;
                }
            }
            return false;
        }
        @Override
               public int hashCode()
               {
                   int result = first != null ? first.hashCode() : 0;
                   result = 31 * result + (second != null ? second.hashCode() : 0);
                   return result;
               }

    }

}
