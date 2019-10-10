package com.bjsxt.list2;

import com.bjsxt.list.IndexOutOfBoundsException;
import com.bjsxt.list.Iterator;

public class SingleLinkedList implements List {

    private Node head = new Node();

    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        Node p = head;
        for (int index = 0 ; index <= i ;index++){
            p = p.next;

        }
//        return p.data;//返回当前节点的数据
        return p; //返回当前节点
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        if(i > size || i < 0 ){
            throw new IndexOutOfBoundsException("数组索越界产生异常： "+i);
        }

        Node perviousNode = head;
        perviousNode = (Node)this.get(i-1);
        Node newNode = new Node(e);
        newNode.next = perviousNode.next;
        perviousNode.next = newNode;

    }

    @Override
    public void add(Object e) {
        this.add(size, e);
        size++;

    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        if(i > size || i < 0 ){
            throw new IndexOutOfBoundsException("数组索越界产生异常： "+i);
        }
        Node perviousNode = (Node)get(i-1);
        Node currentNoe = perviousNode.next;
        perviousNode.next = currentNoe.next;
        currentNoe.next = null;


        //数量减一
        size--;

        return null;


    }

    @Override
    public boolean remove(Object e) {

        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    @Override
    public String toString() {
        Node p = head;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0 ; i < size ; i++){
            p = p.next;
            builder.append(p.data+",");
        }
        builder.append("]");
        builder.deleteCharAt(builder.length()-2);
        return builder.toString();
    }
}
