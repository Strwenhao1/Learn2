package com.bjsxt.list;

/**
 * 自定义异常
 */
public class IndexOutOfBoundsException extends RuntimeException {
    public IndexOutOfBoundsException(){

    }
    public IndexOutOfBoundsException(String message){
        super(message);
    }
}
