package com.ua.test.my.test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Dmitriy on 30.04.2015.
 */
public class TestIterat00 {
    public static void main(String[] args) {

      Iterator<Integer> iterA = Arrays.asList(10,20,30,40).iterator();
        Iterator<Integer> iterB = Arrays.asList(15,25,35,45,55).iterator();

        for (Iterator<Integer> iter = merge(iterA,iterB); iter.hasNext();)
        {
            System.out.print(" " + iter.next());
        }
        System.out.println();


    }

    private static Iterator<Integer> merge(  final Iterator<Integer> iterA,  final Iterator<Integer> iterB) {

        Iterator<Integer> rezult = new Iterator<Integer>() {
            Iterator<Integer> a = iterA;
            Iterator<Integer> b = iterB;
            @Override
            public boolean hasNext() {
                boolean rez = a.hasNext()||b.hasNext();

                return rez;
            }

            @Override
            public Integer next() {




                Integer one = Integer.MAX_VALUE;
                Integer two = Integer.MAX_VALUE;
                if (a.hasNext() ) {
                    one = a.next();
                }
                if (b.hasNext()) {
                   two = b.next();
                }

                    if (one < two) {
                        if (two != Integer.MAX_VALUE) {
                            b = new PushIterator(two, b);
                        }

                        return one;
                    } else {


                        if (one != Integer.MAX_VALUE) {
                            a = new PushIterator(one, a);
                        }
                        return two;
                    }





            }
        };


      return rezult;
    }


}

class PushIterator implements Iterator<Integer>
{
    private int value;
    private Iterator<Integer> iter;
    private boolean hasElem = true;

    public PushIterator(int value, Iterator<Integer> iterB) {
        this.value = value;
        this.iter = iterB;
    }

    @Override
    public boolean hasNext() {
        return hasElem ? true : iter.hasNext();
    }

    @Override
    public Integer next() {
        if (hasElem)
        {
            hasElem = false;
            return value;

        }
        else
        {
        return iter.next();
        }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
}