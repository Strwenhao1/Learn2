package com.bjsxt.test;

import com.bjsxt.entity.Book;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestBook {
    public static void main(String[] args)  throws Exception{
        SAXReader reader = new SAXReader();
        Document read = reader.read(new FileInputStream("book.xml"));
        Element rootElement = read.getRootElement();
        List<Book> books = new ArrayList<Book>();
        for (Iterator iterator = rootElement.elementIterator();iterator.hasNext();){
            Element element = (Element) iterator.next();
            Book book = new Book();
            for (Iterator it = element.elementIterator();it.hasNext();){
                Element next = (Element)it.next();
                switch (next.getName()){
                    case "title":
                        book.setTitle(next.getText());
                        break;
                    case "author":
                        book.setAuthor(next.getText());
                        break;
                    case "year":
                        book.setYear(next.getText());
                        break;
                    case "price":
                        book.setPrice(Double.parseDouble(next.getText()));
                        break;
                }
                System.out.println(next.getName());
            }
            books.add(book);
        }

        System.out.println(books);
    }
}
