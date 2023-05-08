package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("________Tests_for_MyArrayList______________________");
        MyArrayList<String> myArrayList=new MyArrayList<>();
        myArrayList.add("0");
        System.out.println(myArrayList.toString());

        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        myArrayList.add("11");
        myArrayList.add("12");
        System.out.println(myArrayList.toString());

        myArrayList.remove(13);
        System.out.println(myArrayList.toString());
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(5));
        myArrayList.clear();
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());



        System.out.println("________Tests_for_MyLinkedList________________________");
        MyLinkedList<String> myLinkList = new MyLinkedList<>();
        myLinkList.add("anatolii");
        myLinkList.add("oleksandr");
        myLinkList.add("dmytro");
        System.out.println(myLinkList.get(2));

        myLinkList.print();
        System.out.println(myLinkList.size());
        myLinkList.remove(1);
        myLinkList.print();
        System.out.println(myLinkList.size());
        myLinkList.clear();
        myLinkList.print();

        System.out.println("________Tests_for_MyQueue________________________");
        MyQueue<String> queue = new MyQueue<>();
            queue.add("First");
            queue.add("Second");
            queue.add("Third");
            queue.add("Fourth");
            queue.print();

        System.out.println("Queue size:"+queue.size());
        System.out.println("Peek element");
        System.out.println(queue.peek());
        queue.print();

        System.out.println("Poll element");
        System.out.println(queue.poll());
        queue.print();

        System.out.println("Poll element");
        System.out.println(queue.poll());
        queue.print();

        System.out.println("Queue size:"+queue.size());
        queue.clear();
        queue.print();

        System.out.println("________Tests_for_MyStack__________________________");
        MyStack<String> stack = new MyStack<>();
        stack.push("Anatolii");
        stack.push("Oleksandr");
        stack.push("Dmytro");
        stack.push("Andrii");
        stack.print();
        System.out.println("Stack size: "+stack.size());
        System.out.println();

        System.out.println("Stack after removing 1 element ");
        stack.remove(1);
        stack.print();
        System.out.println("Stack size: "+stack.size());
        System.out.println();

        System.out.println("Element peeked from stack: "+stack.peek());
        stack.print();
        System.out.println("Stack size: "+stack.size());
        System.out.println();

        stack.print();
        System.out.println("Element pop from stack: "+stack.pop());
        stack.print();
        System.out.println("Stack size: "+stack.size());
        System.out.println();

        stack.remove(1);
        stack.print();

        stack.clear();
        stack.print();

        System.out.println("________Tests_for_MyHashMap________________________");

        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        myHashMap.put("oleksandr","Kyiw");
        myHashMap.put("anatolii","Netishyn");
        myHashMap.put("sasha","Dnipro");
        myHashMap.put("igor","Rivne");
        myHashMap.put("yurii","Kowel'");
        myHashMap.put("oleg","Poltava");
        myHashMap.put("dima","Odesa");
        System.out.println(myHashMap.size());
        System.out.println(myHashMap);
        System.out.println("Put element with same key and different value");
        myHashMap.put("igor","Korosten'");
        System.out.println(myHashMap);

        myHashMap.remove("igor");
        System.out.println(myHashMap);
        System.out.println(myHashMap.size());
        myHashMap.remove("anatolii");
        System.out.println(myHashMap);
        System.out.println(myHashMap.size());
        System.out.println("----------------------");
        myHashMap.remove("anatolii");
        System.out.println(myHashMap);
        System.out.println(myHashMap.size());

        System.out.println("Get value for sasha");
        System.out.println(myHashMap.get("sasha"));

        System.out.println("Get value for anatolii");
        System.out.println(myHashMap.get("anatolii"));

        myHashMap.clear();
        myHashMap.clear();
        System.out.println(myHashMap);

    }



}