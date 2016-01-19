package com.javarush.test.level20.lesson10.bonus02;




/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0, 1},        //2     //2
                {1, 1, 0, 0},
                {1, 1, 0, 1, 1, 1}
        };
        int count ;
        count= getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
        a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},         //3       //2
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 3" + " result: " + String.valueOf( count == 3));

        a = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},            //1        //1
                {1, 1, 0, 0}
        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 1" + " result: " + String.valueOf( count == 1));

        a = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},            //3           //3
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}

        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 3" + " result: " + String.valueOf( count == 3));

        a = new byte[][]{
                {1, 1, 0,},
                {1, 0, 0,},           //2         //2
                {0, 1, 1,},

        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 2" + " result: " + String.valueOf( count == 2));

        a = new byte[][]{
                {1, 0, 0,},
                {0, 0, 0,},
                {0, 0, 1,},                //2      //0

        };
        count = getRectangleCount(a);
        System.out.println("Count = " + count + ". Должно быть 2" + " result: " + String.valueOf( count == 2));

        a = new byte[][]{
                {1, 1, 0,},
                {0, 0, 0,},                 //2         //2
                {0, 1, 1,},

        };
        count = getRectangleCount(a);
       System.out.println("Count = " + count + ". Должно быть 2" + " result: " + String.valueOf( count == 2));
    }

    public static int getRectangleCount(byte[][] a) {
            int count = 0;

            int x1 =0;
            int y1 =0;
            int x2 =0;
            int y2 =0;
            for (int i = 0; i < a.length ; i++) {
                for (int j = 0; j < a.length ; j++) {

                    if (a[i][j] == 1) {

                        x1 = i;
                        y1 = j;

                      x2 = getXUp(a,i,j);
                      y2 = getYUp(a,i,j);



                      for (int v = x1; v <= x2; v++)
                      {
                          for (int b = y1; b <=y2; b++)
                          {
                              a[v][b] = 0;
                          }

                      }
                        count++;


                    }


                }

            }
            return count;

        }

      public static int getXUp(byte[][] a,int x,int y)
      {   int i = x;
          int j = y;
          while (i < a.length)
             {
               if (a[i][j] == 0) break;
                    i++;
             }
             i--;


          return i;
      }
     public static int getYUp(byte[][] a,int x,int y)
      {   int i = x;
          int j = y;
          while (j < a.length)
               {
             if (a[i][j] == 0) break;
             j++;
               }
           j--;


          return j;
      }





    }
