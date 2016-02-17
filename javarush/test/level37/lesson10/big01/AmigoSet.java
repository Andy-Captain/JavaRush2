package com.javarush.test.level37.lesson10.big01;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

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
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public boolean isEmpty() {
        return map.keySet().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.keySet().clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AmigoSet<E> amigoSet ;
        try{
            amigoSet = new AmigoSet<>(this);

        }   catch (Exception e)
        {
            throw new InternalError();
        }


        return amigoSet;
    }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(map.size());
        for (E e : map.keySet()) {
            stream.writeObject(e);
        }

        stream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        stream.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));

    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {

            stream.defaultReadObject();
            int size = (int) stream.readObject();
          Set<E> set = new HashSet<>();
           for (int i = 0; i < size; i++)
           {
              set.add((E) stream.readObject());
           }
        int capacity  = (int) stream.readObject();
        float loadFactor = (float) stream.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for (E e : set) {
              map.put(e,PRESENT);
        }


    }


}
