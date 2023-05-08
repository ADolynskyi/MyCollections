package org.example;

import javax.swing.table.TableCellEditor;
import java.util.Objects;

public class MyHashMap<K,V> {
    private int size = 0;

    private static final int Table_SIZE = 4;

    private Node<K, V>[] table = new Node[Table_SIZE];

    public void put(K key, V value) {
        int index = hash(key) & (Table_SIZE - 1);
        Node<K, V> nodes ;
             if(table[index]==null) {
                 table[index]=new Node<>(key,value, hash(key),null);
                 size++;

            }else{
                nodes= table[index];
                 boolean last= false;
                 while(!last){
                     if (nodes.hash == hash(key) && nodes.key.equals(key)) {
                         nodes.item = value;
                         last=true;
                         return;
                     }
                     if(nodes.next==null){
                         last=true;
                         nodes.next=new  Node<>(key,value, hash(key),null);
                         size++;
                     }else{
                         nodes=nodes.next;
                     }
                 }


            }
        }
    public V get(K key) {
        int index = hash(key) & (Table_SIZE - 1);
        Node<K, V> nodes ;
        nodes= table[index];
        if(nodes==null){
            System.out.println("No such element");
            return null;
        }
        boolean last= false;
        while(true){
            if (nodes.hash == hash(key) && nodes.key.equals(key)) {
                return nodes.item;
            }
            if(nodes.next==null){
                System.out.println("No such element");
                return null;
            }
            nodes=nodes.next;
        }


    }
        public void clear(){
       for(int i=0; i<table.length;i++) {
           table[i] = null;
        }
        size=0;

    }
        public int size(){

        return size;

    }
        public void remove(K key){

        for(int i=0; i<table.length;i++){
            Node<K,V> curentNode=table[i];
            if(curentNode==null){
                continue;
            }
            Node<K,V> nextNode=table[i].next;

            if (curentNode.hash == hash(key) && curentNode.key.equals(key)) {
                if(curentNode.next!=null){
                    table[i]=curentNode.next;
                }else {
                    table[i]=null;
                }
                size--;
                return;
            }else {
                if(nextNode!=null){
                    if (nextNode.hash == hash(key) && nextNode.key.equals(key)) {
                        if(nextNode.next!=null){
                            table[i].next=nextNode.next;
                        }else {
                            table[i].next=null;
                        }
                        size--;
                        return;
                    }else{
                        curentNode=table[i].next;
                        nextNode=curentNode.next;
                        while(nextNode!=null){
                            if (nextNode.hash == hash(key) && nextNode.key.equals(key)) {
                                if(nextNode.next!=null){
                                    curentNode.next=nextNode.next;
                                }else {
                                    curentNode.next=null;
                                }
                                size--;
                                return;
                            }
                            curentNode=nextNode;
                            nextNode=nextNode.next;

                            }




                    }

                }
            }
        }

        }

     private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
       for(int i=0;i<table.length;i++){
           Node<K,V> node = table[i];

           if(node!=null){
               while (node!=null){
               stringBuilder.append("{");
               stringBuilder.append(node.toString()).append("}");
               node=node.next;
           }}
       }


        return String.valueOf(stringBuilder);
    }

    private static class Node<K, V> {
            V item;
            final K key;
            final int hash;
            Node<K, V> next;

            Node(K key, V element, int hash, Node<K, V> next) {
                this.hash = hash;
                this.next = next;
                this.key = key;
                this.item = element;
            }

            public final K getKey() {
                return key;
            }

            public final V getValue() {
                return item;
            }

            public final String toString() {
                return key + "=" + item;
            }
            @Override
            public boolean equals(Object obj){
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Node<K,V> e = (Node<K, V>) obj;
                if (Objects.equals(key, e.key))
                    return true;
                return false;

            }


        }

}