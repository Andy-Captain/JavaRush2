package com.ua.test;

/**
 * Created by Dmitriy on 06.04.2015.
 */
public class TestNode {

    public static void main(String[] args) {
        Node node = new Node();
        node.addNode(5);
        node.addNode(14);
        node.addNode(10);
        node.addNode(3);
        node.addNode(3);
        node.addNode(3);
        node.addNode(3);
        node.addNode(3);


        System.out.println(node.toString());
        System.out.println("lenght = " + node.lenght());
       System.out.println("max = " +node.max());
       System.out.println("sum = " +node.summ());
       node.delite();
        System.out.println(node.toString());
        //node.delite();
        System.out.println(node.toString());
        node.deliteEl(3);
        System.out.println(node.toString());
        node.deliteEl(10);
        System.out.println(node.toString());

    }


}



 class Node
{

    Node tail;
    int value;
    Node next;




    public void addNode(int value)
    {
        Node a = new Node();
        a.value = value;

        if (tail == null)
        {
            tail = a;

        }
        else{
           a.next = tail;
            tail = a;
        }



    }

    public int lenght(){
        int count = 0;
        if (tail == null)
        {
            return count;
        }
        else
        {
            Node temp = tail;

            while (temp != null)
            {
                count++;
                temp = temp.next;
            }
            return count;
        }

    }


    public  int max()
    {
         Node tmp = tail;
         int max = Integer.MIN_VALUE;
         if (tmp == null)
         {
             return 0;
         }
        while (tmp != null)
        {
          max = Math.max(max,tmp.value);
            tmp = tmp.next;
        }

      return max;
    }

    public int summ()
    {
        Node tmp = tail;
        int sum = 0;
        if (tmp == null)
        {
            return 0;
        }
            while (tmp != null)
            {
               sum = sum + tmp.value;
                tmp = tmp.next;

            }


      return sum;
    }

    public void delite()
    {
        if ( tail == null)
        {
            return;
        }

        else{

           tail =  tail.next ;

            return;

        }

    }

    public void deliteEl(int data)
    {
        if (tail == null)
        {
            return;
        }
        if (tail.value == data)
        {
            tail = tail.next;
        }
        Node t = tail;
        while (t.next != null)
        {

            if (t.next.value == data )
            {

                t.next = t.next.next;
                return;
            }

            t = t.next;
        }




    }


    @Override
    public String toString() {
        Node t = tail;

       {
             String s ="";
            while (t != null)
            {
                s = s+t.value + " ->";
                t = t.next;
            }
            s = s + "*";
            return s;
        }
    }
}
