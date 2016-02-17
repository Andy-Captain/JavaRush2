package com.javarush.test.level37.lesson10.big01;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private final static Object PRESENT = new Object();
    private HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<E, Object>();
    }

    public AmigoSet(Collection<? extends E> collection) {

        map = new HashMap<E, Object>((int) Math.max(16, collection.size() / .75f));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        try {
         map.put(e, PRESENT);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
