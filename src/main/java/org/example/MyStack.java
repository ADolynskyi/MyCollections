package org.example;

public class MyStack<E> {

    private MyLinkedList<E> linkList= new MyLinkedList<>();

    public void push(E e){
        linkList.add(e);
    }
    public void clear(){
        linkList.clear();
    }
    public int size(){
        return linkList.size();
    }
    public E peek(){
       return linkList.get(size()-1);

    }
    public E pop(){
        E temp= linkList.get(size()-1);
        linkList.remove(size()-1);
        return temp;
    }
    public void print(){
        linkList.print();
    }
    public void remove(int index){
        try {
            linkList.remove(index);
        }catch (NullPointerException e){
            System.out.println("No such index in stack");
        }
    }
}
