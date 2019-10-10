package com.bjsxt.list3;

import com.bjsxt.list.Iterator;

public class LinkedList implements List {
    transient int size = 0 ;

    transient Node first;//指向双向链表的第一个元素

    transient Node last;//指向双向链表的最后一个元素


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

//双线链表的一个节点
        public Node( Node<E> prev,E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        return node(i).item;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public void add(int index, Object element) {
        if(index == size){
            linkLast(element);
        }else {
            linkBefore(element,node(index));
        }
    }
    Node node(int index){
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


    void linkBefore(Object e, Node succ){
        final Node pred = succ.prev;
        final Node newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    @Override
    public void add(Object element) {
        linkLast(element);
    }

     void linkLast(Object element) {
        final Node l = last;
        final Node newNode = new Node<>(l,element,null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else {
            l.next =newNode;
            size++;
        }
    }


}
