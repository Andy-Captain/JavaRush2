package com.javarush.test.level35.lesson10.bonus01;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров,
- создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
//        Set<? extends Animal> allAnimals = getAllAnimals("C://pathToClasses/");
//    Set<? extends Animal> allAnimals = getAllAnimals("C:/JavaRushHomeWork/out/production/JavaRushHomeWork/com/ua/test/test_jr_35");
    Set<? extends Animal> allAnimals = getAllAnimals("C:\\JavaRushHomeWork\\out\\production\\JavaRushHomeWork\\com\\javarush\\test\\level35\\lesson10\\bonus01\\data");
    System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        Set<Animal> rezSet = new HashSet<>();

        if (!pathToAnimals.endsWith("\\")) {
            pathToAnimals += "\\";
        }
        if (pathToAnimals.endsWith("/")) {
            pathToAnimals += "/";
        }

        File file = new File(pathToAnimals);

        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });
        final String finalPathToAnimals = pathToAnimals;
        for (String s : list) {


            ClassLoader classLoader = new ClassLoader() {
                @Override
                protected Class<?> findClass(String name) throws ClassNotFoundException {
                    byte bytes[] = null;
                    String fullPath = finalPathToAnimals + name;

                    try {
                        InputStream is = new FileInputStream(new File(fullPath));

                        long length = new File(fullPath).length();

                        bytes = new byte[(int) length];

                        int offset = 0;
                        int numRead = 0;
                        while (offset < bytes.length
                                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                            offset += numRead;
                        }

                        is.close();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return defineClass(null, bytes, 0, bytes.length);
                }
            };

            try {
                Class<?> aClass = classLoader.loadClass(s);

                Constructor<?>[] constructors = aClass.getConstructors();

                Class<?>[] interfaces = aClass.getInterfaces();

                boolean constr = false;
                boolean inter = false;
                for (Constructor<?> constructor : constructors) {

                    if (Modifier.isPublic(constructor.getModifiers()) && constructor.getParameterTypes().length == 0) {
                        constr = true;

                    }
                }
                for (Class<?> anInterface : interfaces) {


                    if (anInterface.getSimpleName().equals("Animal")) {

                        inter = true;

                    }

                }


                if (inter && constr) {
                    Object o = aClass.newInstance();
                    rezSet.add((Animal) o);
                }


            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }


        }


        return rezSet;
    }
}
