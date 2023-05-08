package org.example;

public class MyQueue<E> {
    private int size=0;
    private Node<E> first;
    private Node<E> last;

    public E peek(){
        final Node<E> f=first;

        return f.item;
    }
    public E poll(){
        final Node<E> f=first;
        first=f.next;
        first.prev = null;
        this.size--;
        return f.item;

    }
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

    public int size(){
        return size;
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

        Node(Node<E> prev, E element, Node<E> next ){
            this.next=next;
            this.prev=prev;
            this.item=element;
        }

    }
}
