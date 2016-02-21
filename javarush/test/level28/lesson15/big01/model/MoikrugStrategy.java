package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class MoikrugStrategy implements Strategy{

//     private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data2.html";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int pageNumber = 1;

        try {

            while (true) {

                //Получаем документ для парсинга и увеличиваем счетчик страниц
                Document doc = getDocument(searchString, pageNumber++);
                //Если документа нет - выходим из цикла
                if (doc == null) {
                    break;
                }

                //делаем выборку с указанными аттрибутами
                Elements elements = doc.getElementsByClass("job");
                //Если вакансий нет - выходим из цикла
                if (elements.size() == 0) {
                    break;
                }

                //парсим
                for (Element element : elements) {
                    String siteName = "https://moikrug.ru";

                    Vacancy vacancy = new Vacancy();

                    Element titleE = element.getElementsByClass("title").first();
                    if (titleE != null) {
                        String title = titleE.select("a").first().text();
                        String url = siteName + titleE.select("a").attr("href");

                        vacancy.setTitle(title);
                        vacancy.setUrl(url);
                    }

                    Element salaryE = element.getElementsByClass("count").first();
                    if (salaryE != null) {
                        String salary = salaryE.text();

                        vacancy.setSalary(salary);
                    }

                    Element cityE = element.getElementsByClass("location").first();
                    if (cityE != null) {
                        String city = cityE.text();

                        vacancy.setCity(city);
                    }

                    Element companyE = element.getElementsByClass("company_name").first();
                    if (companyE != null) {
                        String companyName = companyE.select("a[href]").text();

                        vacancy.setCompanyName(companyName);
                    }
                    vacancy.setSalary(siteName);
                    vacancies.add(vacancy);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
