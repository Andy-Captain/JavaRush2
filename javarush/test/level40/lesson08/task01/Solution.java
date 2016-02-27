package com.javarush.test.level40.lesson08.task01;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* Отправка GET-запроса через сокет
Перепиши реализацию метода getSite, он должен явно создавать и использовать сокетное соединение Socket с сервером.
Адрес сервера и параметры для GET-запроса получи из параметра url.
Порт используй дефолтный для http.
Классы HttpURLConnection, HttpClient и т.д. не использовать.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {

        String host = url.getHost();
        int port = url.getDefaultPort();
        String path = url.getPath();

        Socket socket = null;
        try {
             socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            printWriter.println("GET "+path+ " HTTP/1.1\r\n" +
                                "Host: "  + host+"\r\n" +
                                "Connection: close\r\n\r\n");
            printWriter.flush();



            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String responseLine;

            while ((responseLine = br.readLine()) != null) {

                System.out.println(responseLine);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}