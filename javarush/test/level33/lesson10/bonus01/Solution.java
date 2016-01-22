package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter sw = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, sw);
        String strComment = "<!--" + comment + "-->";
//        String stringObj = sw.toString();


        String stringObj = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                "<second>\n" +

                "    <second>some string</second>\n" +

                "    <second>some string</second>\n" +

                "    <second><![CDATA[need CDATA because of < and >]]></second>\n" +

                "    <second/>\n" +
                "</second>";


        String replaceAll = stringObj.replaceAll("<" + tagName + ">", strComment + "\n" + "    <" + tagName + ">");
        replaceAll = replaceAll.replaceAll("<" + tagName + "/>", strComment + "\n" + "    <" + tagName + ">");
        return replaceAll;
    }

    public static void main(String[] args) throws JAXBException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 4;
//        String s = toXmlWithComment(cat, "age", "it's a comment");
        String s = toXmlWithComment(cat, "second", "it's a comment");
        System.out.println(s);

    }

    @XmlType(name = "cat")
    @XmlRootElement
    static class Cat {
        public String name;
        public int age;
        public int weight;

        public Cat() {
        }
    }

}
