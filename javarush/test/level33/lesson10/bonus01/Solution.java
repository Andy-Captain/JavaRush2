package com.javarush.test.level33.lesson10.bonus01;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;

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
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws Exception {
        StringWriter sw = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        marshaller.marshal(obj, document);
        Element node = document.getDocumentElement();  //root element
        walker(node, document);
        NodeList nodeList = document.getElementsByTagName(tagName);
        Comment commentXml;
        for (int i = 0; i < nodeList.getLength(); i++) {    //add all comment
            commentXml = document.createComment(comment);
            nodeList.item(i).getParentNode().insertBefore(commentXml, nodeList.item(i));
        }
        String rezult = transormDOMtoString(document);
        rezult = rezult.replaceAll("&amp;", "&").replaceAll("&quot;", "\"").replaceAll("&lt;", "<").
                replaceAll("&gt;", ">").replaceAll("&apos;", "'");
        return rezult;
    }


    public static void main(String[] args) throws Exception {
        String result = Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>");
        System.out.println(result);
    }

    @XmlType(name = "anExample")     //example class
    @XmlRootElement
    public static class AnExample {
        public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
    }

    public static void walker(Node node, Document dc) {

        for (Node i = node.getFirstChild(); i != null; i = i.getNextSibling()) {
            if (!i.hasChildNodes()) {
                String context = i.getTextContent();

                if (context.matches("(.*)[<>&'\"](.*)")) {      //if tag data contains < > & \ '
                    String textContent = i.getTextContent();      //change CDDATA

                    i.setTextContent("<![CDATA[" + textContent + "]]>");
                }


            } else {
                walker(i, dc);
            }
        }
    }


    public static String transormDOMtoString(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        return out.toString();

    }
}



