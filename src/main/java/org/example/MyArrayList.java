package org.example;

import java.sql.Array;
import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_SIZE= 10;
    private E[] elements;

    private int size=0;
    public MyArrayList(){
    this.elements= (E[]) new Object[DEFAULT_SIZE];
    }

    public void add(E e){
        size++;
        if(size==elements.length){
            expandArray();
        }
            elements[size-1]=e;

    }
    private void expandArray(){
        elements= Arrays.copyOf(elements,(int)(elements.length*1.5));

    }

    public void remove(int index){
        if(index==size|| index<0){
            System.out.println("Your index out of range");
        }else {

            for (int i = 0; i < size; i++) {
                if (i > index) {
                    elements[i - 1] = elements[i];
                }
            }
            size--;
            elements[size] = null;
        }
    }

        public String toString(){
        StringBuilder string=new StringBuilder() ;
        for( E element: elements){
            if(element!=null) {
                string.append(element).append(" ");
            }
        }
        return string.toString().trim();
        }

        public int size(){
        return size;
        }
        public E get(int index){
            if(index==size|| index<0){
                System.out.println("Your index out of range");
                return null;
            }else {
                return elements[index];
            }
        }

        public void clear(){
          elements=  (E[]) new Object[DEFAULT_SIZE];
          size=0;
        }
}
