package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 21.01.2016.
 */


@XmlType(name = "shop")
@XmlRootElement
public class Shop {

    @XmlElementWrapper(name = "goods", nillable = true)
   @XmlElement(name = "names")
    public List<String> names = new ArrayList<>();


    @XmlElement(name = "count")
    int count;
    @XmlElement(name = "profit")
    double profit;

    @XmlElement(name = "secretData")
    public List<String> secretData = new ArrayList<>();

    public Shop() {
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + names +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }
}

