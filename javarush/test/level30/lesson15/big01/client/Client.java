package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

/**
 * Created by Dmitriy on 19.01.2016.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;


    protected String getServerAddress() {

        ConsoleHelper.writeMessage("Enter server address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter user name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {

        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Exception send Text Message");
            clientConnected = false;
        }
    }

    public void run() {

        try {
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();
            synchronized (this) {
                this.wait();
            }


        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Exception in Socket Thread");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Connection found for return enter 'exit' ");
        } else {
            ConsoleHelper.writeMessage("Error in run client");
        }

        String mess = "";
        while (clientConnected) {

            mess = ConsoleHelper.readString();
            if (mess.equalsIgnoreCase("exit")) {
                break;
            }
            if (shouldSentTextFromConsole()) {
                sendTextMessage(mess);
            }


        }


    }

    public class SocketThread extends Thread {

        @Override
        public void run() {


        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
