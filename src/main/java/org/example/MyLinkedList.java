package org.example;

import java.util.LinkedList;

public class MyLinkedList<E> {

    private int size=0;
    private Node<E> first;
    private Node<E> last;


    public MyLinkedList(){}

   public void add(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }
    private Node<E> getNode(int index){
            if(index>=size) return null;
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            if(index==0){
                return x;
            }
            index--;
            x = next;
        }

        return null;

    }

    public E get(int index){
        Node<E> x=getNode(index);
        if(x!=null){
        return x.item;
    }
        return null;
    }


    public void remove(int index){
        try {
            Node<E> node = getNode(index);
            if (node.prev == null) {
                Node<E> nextNode = node.next;
                nextNode.prev = null;
                node.next = null;
                node.item = null;
                node.prev = null;

            } else if (node.next == null) {
                Node<E> prevNode = node.prev;
                prevNode.next = null;
                node.next = null;
                node.item = null;
                node.prev = null;

            } else {
                Node<E> nextNode = node.next;
                Node<E> prevNode = node.prev;
                nextNode.prev = prevNode;
                prevNode.next = nextNode;
                node.next = null;
                node.item = null;
                node.prev = null;

            }
        }catch (NullPointerException e){
            System.out.println("No element with such index");
        }
        size--;

    }



    public int size(){
       return size;
    }

    public void clear() {
        this.size=0;
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
    }
    public void print(){
        try {

        for (Node<E> x = first; x != null; ) {



                Node<E> next = x.next;

            System.out.print(x.item.toString());
            System.out.print(" ");
            x = next;

        }
        }catch (NullPointerException e){
            System.out.println("No elements to be printed");
        }
        System.out.println();
    }





    private static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element,Node<E> next ){
            this.next=next;
            this.prev=prev;
            this.item=element;
        }

    }
}
