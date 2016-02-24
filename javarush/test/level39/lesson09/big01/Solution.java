package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
       // LogParser logParser = new LogParser(Paths.get("c:/logs/"));
       LogParser logParser = new LogParser(Paths.get("C:/JavaRushHomeWork/src/com/javarush/test/level39/lesson09/big01/logs/"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
       System.out.println(logParser.getUniqueIPs( new Date(), null));
       System.out.println(logParser.getIPsForUser( "Eduard Petrovich Morozko",null, null));
        System.out.println(logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, new Date()));
        System.out.println(logParser.getIPsForStatus(Status.ERROR, null, new Date()));

    }
}
