package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;

import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном,
так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        int[][] crossword2 = new int[][]{
                {'f', 'd', 'f', 'e', 'w', 'e'},
                {'e', 's', 'n', 's', 'n', 'b'},
                {'o', 'm', 'a', 'e', 'e', 'g'},
                {'h', 'm', 'o', 'm', 'd', 'h'},
                {'e', 'g', 'r', 'h', 'e', 'e'}
        };




       detectAllWords(crossword, "home", "same");

        List<Word> l =detectAllWords(crossword2, "home", "same");

        for (Word word : l) {
            System.out.println(word.toString());
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();
        for (String word : words) {
            word = word.toLowerCase();
          char [] chars = word.toCharArray();
             char firstLetter = chars[0];
            int charlenght = chars.length;
            for (int i = 0; i < crossword.length; i++)
            {
                for (int j = 0; j < crossword[i].length; j++)
                {
                    if (crossword[i][j] == firstLetter && charlenght == 1)
                       {
                           Pair p = new Pair(i,j,i,j);
                           addToListFindWord(list,word,p);
                       }
                    if (crossword[i][j] == firstLetter && charlenght > 1)
                     {
                         Pair p = findWordToEast(crossword,i,j,chars);
                         addToListFindWord(list,word,p);
                         Pair p1 = findWordToWest(crossword,i,j,chars);
                         addToListFindWord(list,word,p1);
                         Pair p2 = findWordToSouth(crossword,i,j,chars);
                         addToListFindWord(list,word,p2);
                         Pair p3 = findWordToNord(crossword,i,j,chars);
                         addToListFindWord(list,word,p3);
                         Pair p4 = findWordToSouthEast(crossword,i,j,chars);
                         addToListFindWord(list,word,p4);
                         Pair p5 = findWordToWestNord(crossword,i,j,chars);
                         addToListFindWord(list,word,p5);
                         Pair p6 = findWordToNordEast(crossword,i,j,chars);
                         addToListFindWord(list,word,p6);
                         Pair p7 = findWordToWestSouth(crossword,i,j,chars);
                         addToListFindWord(list,word,p7);
                     }

                }

            }

        }

        return list;
    }

    public  static void addToListFindWord(List<Word> list,String word, Pair pair)
    {    int x1 = pair.getX1();
         int y1 = pair.getY1();
         int x2 = pair.getX2();
         int y2 = pair.getY2();

          if (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 )
          {
              Word word1 = new Word(word);
              word1.setStartPoint(y1,x1);
              word1.setEndPoint(y2,x2);
              list.add(word1);

          }

    }
    public static Pair findWordToEast(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length; ;

        for (int i = y, j = 0; i < (crossword[x].length)&& j <chars.length; i++, j++)
           {
              if (crossword[x][i] == chars[j])
                 {
                    worldLenght--;
                 if (worldLenght == 0)
                     return new Pair(x,y,x,i);
                 }

           }

       return new Pair(-1,-1,-1,-1);
    }

    public static Pair findWordToWest(int[][] crossword, int x, int y, char [] chars )
    {
            int worldLenght = chars.length;
               for (int i = y, j = 0; i >= 0 && j <chars.length; i--, j++)
               {
                   if (crossword[x][i] == chars[j])
                   {
                       worldLenght--;
                       if (worldLenght == 0)
                          {
                            return new Pair(x,y,x,i);
                          }
                   }
               }
        return new Pair(-1,-1,-1,-1);
    }

    public static Pair findWordToSouth(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length;
        for (int i = x, j = 0; i < (crossword.length)&& j <chars.length; i++, j++)
            {
            if (crossword[i][y] == chars[j])
                {
                   worldLenght--;
                 if (worldLenght == 0)
                     {
                       return new Pair(x,y,i,y);
                     }

                }
         }

      return new Pair(-1,-1,-1,-1);

    }
    public static Pair findWordToNord(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length;
        for (int i = x, j = 0; i >= 0 && j <chars.length; i--, j++)
            {
            if (crossword[i][y] == chars[j])
                {
                   worldLenght--;
                 if (worldLenght == 0)
                     {
                       return new Pair(x,y,i,y);
                     }

                }
         }

      return new Pair(-1,-1,-1,-1);

    }
    public static Pair findWordToSouthEast(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length; ;

                for (int i = y, i1 =x, j = 0; i < (crossword[x].length)&& j <chars.length && i1 < crossword.length; i++, i1++, j++)
                   {
                      if (crossword[i1][i] == chars[j])
                         {
                            worldLenght--;
                         if (worldLenght == 0)
                             return new Pair(x,y,i1,i);
                         }

                     }

               return new Pair(-1,-1,-1,-1);
    }
    public static Pair findWordToWestNord(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length; ;

                for (int i = y, i1 =x, j = 0; i >= 0 && j <chars.length && i1 >= 0  ; i--, i1--, j++)
                   {
                      if (crossword[i1][i] == chars[j])
                         {
                            worldLenght--;
                         if (worldLenght == 0)
                             return new Pair(x,y,i1,i);
                         }

                     }

               return new Pair(-1,-1,-1,-1);
    }
    public static Pair findWordToNordEast(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length; ;

                for (int i = y, i1 =x, j = 0; i < (crossword[x].length)  && j <chars.length && i1 >= 0  ; i++, i1--, j++)
                   {
                      if (crossword[i1][i] == chars[j])
                         {
                            worldLenght--;
                         if (worldLenght == 0)
                             return new Pair(x,y,i1,i);
                         }

                     }

               return new Pair(-1,-1,-1,-1);
    }
   public static Pair findWordToWestSouth(int[][] crossword, int x, int y, char [] chars )
    {
        int worldLenght = chars.length; ;

                for (int i = y, i1 =x, j = 0; i >= 0  && j <chars.length && i1 < crossword.length  ; i--, i1++, j++)
                   {
                      if (crossword[i1][i] == chars[j])
                         {
                            worldLenght--;
                         if (worldLenght == 0)
                             return new Pair(x,y,i1,i);
                         }

                     }

               return new Pair(-1,-1,-1,-1);
    }


    public static class Pair
    {
        int x1 ,y1, x2, y2;


        public Pair(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }

        public int getX2() {
            return x2;
        }

        public int getY2() {
            return y2;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
