package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Dmitriy on 18.01.2016.
 */
public class Server {

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter the port..");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Server starting...");
            ConsoleHelper.writeMessage(serverSocket.getInetAddress()+" "+serverSocket);
            while (true)
            {
               Handler handler = new Handler(serverSocket.accept());
                handler.start();

            }


        } catch (IOException e) {
            ConsoleHelper.writeMessage("ServerSocket Exception");
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                ConsoleHelper.writeMessage("ServerSocket Exception");
            }
        }


    }




    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


    }

}
