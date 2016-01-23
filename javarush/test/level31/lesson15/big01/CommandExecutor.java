package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitriy on 23.01.2016.
 */
public class CommandExecutor {


    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<>();
    static {
              allKnownCommandsMap.put(Operation.ADD,new ZipAddCommand());
              allKnownCommandsMap.put(Operation.CONTENT,new ZipContentCommand());
              allKnownCommandsMap.put(Operation.CREATE,new ZipCreateCommand());
              allKnownCommandsMap.put(Operation.EXTRACT,new ZipExtractCommand());
              allKnownCommandsMap.put(Operation.REMOVE,new ZipRemoveCommand());
              allKnownCommandsMap.put(Operation.EXIT,new ExitCommand());
           }
    private CommandExecutor(){}

    public static void execute(Operation operation){
        try {
           allKnownCommandsMap.get(operation).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
