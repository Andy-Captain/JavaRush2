package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dmitriy on 29.10.2014.
 */
public class UkrainianHen extends Hen implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 200;
    }

    @Override
        String getDescription()
        {



            return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth()+ " яиц в месяц.";
        }
}
