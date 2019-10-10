package com.bjsxt.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList implements List{

    private transient Object[] elementData;
    private int size;//集合中元素的个数，不是分配空间的大小

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initialCapacity){
      if(initialCapacity < 0){
          throw new IllegalArgumentException("初始化长度必须大于0： "+initialCapacity);
      }
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if(i > size || i < 0 ){
            throw new IndexOutOfBoundsException("数组索越界产生异常： "+i);
        }
        return elementData[i];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Object e) {
        int index = -1; //表示元素不存在
        for (int i = 0 ; i < size ;i++){
            if (elementData[i].equals(e)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void add(int i, Object e) {
        //首先判断数组是否已满，如果数组已满，则扩容
        if(size == elementData.length){
            elementData = Arrays.copyOf(elementData, size*2);
        }
        for (int index = size ; index >i ; index--){
            elementData[index] = elementData[index-1];
        }

//        System.arraycopy(elementData, i, elementData, i+1, size-i);
        //添加元素
        elementData[i] = e;
        size++;
    }

    @Override
    public void add(Object e) {
        //首先判断数组是否已满，如果数组已满，则扩容
        if(size == elementData.length){
//            System.out.println("扩容");
            //创建新的数组
//            Object[] newArray = new Object[size*2];
//            //将原数组的元素放入新的数组
//            for (int i=0 ;i< size ; i ++){
//                newArray[i] = elementData[i];
//            }
//            //改变原数组引用
//            elementData = newArray;

            elementData = Arrays.copyOf(elementData, size*2);

        }
        //添加元素
        elementData[size] = e;
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
        for (int index = i; index < size-1;index++){
            elementData[index] = elementData[index+1];
        }
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
        return new Itr();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(elementData[i]+",");
        }
        if(size>0){
            builder.deleteCharAt(builder.length()-1);
        }
        builder.append("]");

        return builder.toString() ;
    }

    private class Itr<T> implements Iterator<T>{
        int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            int i = cursor;
            if(i >= size){
                throw new NoSuchElementException("没有这个元素，cursor: "+cursor);
            }
            cursor++;
            return (T)elementData[i];
        }
    }


}
