package com.javarush.test.level29.lesson15.big01.car;
import java.util.Date;


public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;
    double fuel;
    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;
    private int type;
    private boolean driverAvailable;
    private int numberOfPassengers;
    protected Car(int type, int numberOfPassengers) { //10
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public static Car create(int type, int numberOfPassengers) //10.1.3
    {
        switch (type)
        {
            case 0:
                return new Truck(numberOfPassengers);
            case 1:
                return new Sedan(numberOfPassengers);
            case 2:
                return new Cabriolet(numberOfPassengers);
            default:
                return null; /*new Car(type, numberOfPassengers)*/
        }
    }
    public void fill(double numberOfLiters) throws Exception // 10.1
    {
        if (numberOfLiters < 0)
            throw new Exception(); //return -1;
        fuel += numberOfLiters;
        //return 0;
    }
    private boolean canPassengersBeTransferred() //12.1.1
    {
        if(isDriverAvailable() && fuel > 0){
            return true;
        }
        else return false;
    }
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd)
    {
        double consumption;
        if (!isSummer(date,SummerStart,SummerEnd) ) {
            consumption = getWinterConsumption(length);
        }
        else {
            consumption = getSummerConsumption(length) ;
        }
        return consumption;
    }
    public boolean isSummer(Date date , Date summerStart, Date summerEnd) // 10.2
    {
        return date.after(summerStart) && date.before(summerEnd);
    }
    public double getWinterConsumption(int length) //10.2
    {
        return length*winterFuelConsumption + winterWarmingUp;
    }
    public double getSummerConsumption(int length) // 10.2
    {
        return length * summerFuelConsumption;
    }
    public int getNumberOfPassengersCanBeTransferred() { //12.1.2
        if (canPassengersBeTransferred()){
            return numberOfPassengers;
        }
        return 0;
    }
    public boolean isDriverAvailable() {
        return driverAvailable;
    }
    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }
    public void startMoving() { //12.2
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }
    public void fastenPassengersBelts() {
    }
    public void fastenDriverBelt() {
    }
    public abstract int getMaxSpeed();  //12.3
}
