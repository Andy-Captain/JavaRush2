package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота).
Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    double top;
    double left;
    double width;
    double height;

    public static void main(String[] args)
    {
        Rectangle rec = new Rectangle();

    }
    public void initialize(double t, double l, double w, double h)
    {
        top = t;
        l = left;
        w = width;
        h = height;
     }
    public void initialize(double t, double l)
        {
            top = t;
            l = left;
           width =0;
           height =0;
         }
    public void initialize(double t, double l, double w)
            {
                top = t;
                l = left;
                w = width ;
                height = width ;

             }
    public void initialize(Rectangle copy)
        {
            copy.top = top;
            copy.left = left;
            copy.width = width;
            copy.height = height;
         }


}
