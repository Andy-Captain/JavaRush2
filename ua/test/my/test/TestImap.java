package com.ua.test.my.test;
import javax.mail.*;
import java.util.Properties;

public class TestImap {

    public static void main(String[] args) throws Exception {
        final String user = "*****@ukr.net"; // имя пользователя
        final String pass = "****";    // пароль
        final String host = "imap.ukr.net";     // адрес почтового сервера

        // Создание свойств
        Properties props = new Properties();

        //включение debug-режима
        props.put("mail.debug", "true");

        //Указываем протокол - IMAP с SSL
        props.put("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props);
        Store store = session.getStore();

        //подключаемся к почтовому серверу
        store.connect(host, user, pass);

        //получаем папку с входящими сообщениями
        Folder inbox = store.getFolder("INBOX");

        //открываем её только для чтения
        inbox.open(Folder.READ_ONLY);

        //получаем последнее сообщение (самое старое будет под номером 1)
        Message m = inbox.getMessage(inbox.getMessageCount());
        Multipart mp = (Multipart) m.getContent();
        BodyPart bp = mp.getBodyPart(0);

        //Выводим содержимое на экран
        System.out.println(bp.getContent());
    }
}