package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Dmitriy on 13.01.2016.
 */
public class HtmlView implements View {

    private Controller controller;
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/" + "vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> list) {
         Document document= null;
        String rezult = null;
        try {
            document = getDocument();
            Element templElement = document.select(".template").first();

            Element template = templElement.clone();
            template.removeAttr("style");
            template.removeClass("template");

         document.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : list) {

                Element pattElement = template.clone();
                pattElement.getElementsByClass("city").first().text(vacancy.getCity());
                pattElement.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                pattElement.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element elementA = pattElement.getElementsByTag("a").first();
                elementA.text(vacancy.getTitle());
                elementA.attr("href", vacancy.getUrl());
                templElement.before(pattElement.outerHtml());

            }

            rezult = document.html();
        } catch (IOException e) {
            e.printStackTrace();
            rezult = "Some exception occurred";
        }
        return rezult;
    }

    protected Document getDocument() throws IOException
    {
               return Jsoup.parse(new File(filePath),"UTF-8");
    }

    private void updateFile(String file) {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(file);
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
