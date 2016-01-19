package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;


/**
 * Created by Dmitriy on 17.01.2015.
 */
public class ImageReaderFactory {

    public static ImageReader getReader(ImageTypes it) {

        ImageReader rezult = null;

        if (it==ImageTypes.JPG) {
            rezult = new JpgReader();

        } else if (it==ImageTypes.PNG) {

            rezult = new PngReader();
        } else if (it==ImageTypes.BMP) {

            rezult = new BmpReader();
        } else


                throw new IllegalArgumentException("Неизвестный тип картинки");





        return rezult;
    }
}