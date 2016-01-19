package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dmitriy on 29.10.2014.
 */
public class MoldovanHen extends Hen implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 50;
    }
    @Override
    String getDescription()
    {



        return  super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
 /*
 Методы должны возвращать строку вида:
 <getDescription() родительского класса>  + <" Моя страна - SSSSS. Я несу N яиц в месяц.">
 где SSSSS - название страны
 где N - количество яиц в месяц
  */