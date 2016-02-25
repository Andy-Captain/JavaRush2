package com.javarush.test.level39.lesson09.big01;


import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
       // LogParser logParser = new LogParser(Paths.get("c:/logs/"));
       LogParser logParser = new LogParser(Paths.get("C:/JavaRushHomeWork/src/com/javarush/test/level39/lesson09/big01/logs/"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//       System.out.println(logParser.getUniqueIPs( new Date(), null));
//       System.out.println(logParser.getIPsForUser( "Eduard Petrovich Morozko",null, null));
//        System.out.println(logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, new Date()));
//        System.out.println(logParser.getIPsForStatus(Status.ERROR, null, new Date()));
      //  System.out.println(logParser.getAllUsers());
        //System.out.println(logParser.getNumberOfUniqueIPs(null,null));
       // System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko",null,null));
       // System.out.println(logParser.getUsersForIP("127.0.0.1",null,null));
       // System.out.println(logParser.getLoggedUsers(null,null));
       // System.out.println(logParser.getDownloadedPluginUsers(null,null));
       // System.out.println(logParser.getWroteMessageUsers(null,null));
        //System.out.println(logParser.getSolvedTaskUsers(null,null));
       // System.out.println(logParser.getSolvedTaskUsers(null,null,18));
//        System.out.println(logParser.getDoneTaskUsers(null,null,15));
//        System.out.println(logParser.getDatesForUserAndEvent("Eduard Petrovich Morozko",Event.DONE_TASK,null,null));
//        System.out.println(logParser.getDatesWhenSomethingFailed(null,null));
//        System.out.println(logParser.getDatesWhenErrorHappened(null,null));
//        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Vasya Pupkin",null,null));
//        System.out.println(logParser.getDateWhenUserSolvedTask("Vasya Pupkin",1,null,null));
//        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin",15,null,null));
//        System.out.println(logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko",null,null));
//        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko",null,null));
//        System.out.println(logParser.getNumberOfAllEvents(null,null));
//        System.out.println(logParser.getAllEvents(null,null));
//        System.out.println(logParser.getEventsForIP("192.168.100.2",null,null));
//        System.out.println(logParser.getEventsForUser("Eduard Petrovich Morozko",null,null));
//        System.out.println(logParser.getFailedEvents(null,null));
//        System.out.println(logParser.getErrorEvents(null,null));
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(18,null,null));
//        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(15,null,null));
//        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null,null));
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null,null));
        //////////////////////////
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));


    }
}
