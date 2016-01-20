package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by Dmitriy on 20.01.2016.
 */
public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {

        return "date_bot_" + (int)(Math.random()*99);
    }

    public static void main(String[] args) {
        BotClient client = new BotClient();
        client.run();
    }


    public class BotSocketThread extends SocketThread
    {


    }
}
