package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

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
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {

            ConsoleHelper.writeMessage("user : " + userName + " was added");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("user : " + userName + " left the chat room");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {

            while (true) {
                Message message = connection.receive();
                switch (message.getType()) {
                    case NAME_REQUEST:
                        String userName = getUserName();
                        Message newMess = new Message(MessageType.USER_NAME, userName);
                        connection.send(newMess);
                        break;
                    case NAME_ACCEPTED:
                        notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");

                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                switch (message.getType()) {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");


                }


            }

        }

        @Override
        public void run() {



            try {
                java.net.Socket socket = new Socket(getServerAddress(),getServerPort());
               connection = new Connection(socket);
                clientHandshake();
                 clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
               notifyConnectionStatusChanged(false);



            }

        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
