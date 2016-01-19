package com.javarush.test.level21.lesson16.big01;



import java.util.ArrayList;

/**
 * Created by Dmitriy on 12.03.2015.
 */
public class Hippodrome {

    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {

        game = new Hippodrome();
        Horse horse1 = new Horse("Belka",3,0);
        Horse horse2 = new Horse("Strelka",3,0);
        Horse horse3 = new Horse("Merin",3,0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }
    public void run() {
        int i = 0;
        while (i < 100)
        {
            i++;
            move();
            print();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void move() {
        for (Horse horse : horses) {
             horse.move();
        }

    }
    public void print() {

        for (Horse horse : horses) {
             horse.print();

        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        Horse win = null;
          double max = 0;
        for (Horse horse : horses) {
          double d =  horse.getDistance();
            if (max < d)
            {
                max = d;
            }

        }
        for (Horse horse : horses)
        {
            double d =  horse.getDistance();
            if (max == d)
            {
                win = horse;
            }

        }


        return win;}

    public void printWinner(){

        System.out.println("Winner is " + getWinner().getName()+ "!");
    }

}
