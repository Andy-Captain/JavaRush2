package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 13.01.2016.
 */
public class MoikrugStrategy implements Strategy{

//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s";
    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
                try {
                    int pageNumber = 0;
                    Document doc;
                    while (true) {
                        doc = getDocument(searchString, pageNumber++);
                        if (doc == null) break;

                        Elements elements = doc.select("[class=job]");
                        if (elements.size() == 0) break;

                        for (Element element : elements) {
                            // title
                            Element titleElement = element.select("[class=title]").first();
                            String title = titleElement.text();

                            // salary
                            Element salaryElement = element.select("[class=count]").first();
                            String salary = "";
                            if (salaryElement != null) {
                                salary = salaryElement.text();
                            }

                            // city
                            String city = element.select("[class=location]").first().text();

                            // company
                            String companyName = element.select("[class=company_name]").first().text();

                            // site
                            String siteName = "http://moikrug.ru";

                            // url

                            String url = siteName+titleElement.select("a").attr("href");



                            // add vacancy to the list
                            Vacancy vacancy = new Vacancy();
                            vacancy.setTitle(title);
                            vacancy.setSalary(salary);
                            vacancy.setCity(city);
                            vacancy.setCompanyName(companyName);
                            vacancy.setSiteName(siteName);
                            vacancy.setUrl(url);
                            vacancies.add(vacancy);


                        }


                    }
                }
                catch (Exception e) {

                }

                return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {


            String url = String.format(URL_FORMAT, searchString, page);
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("none")
                    .get();

            return document;
        }
}
