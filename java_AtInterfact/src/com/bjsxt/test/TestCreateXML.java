package com.bjsxt.test;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Documented;

public class TestCreateXML {
    public static void main(String[] args) throws Exception{
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");
        Element title = root.addElement("title");
        Element author = root.addElement("author");
        Element year = root.addElement("year");
        Element price = root.addElement("price");

        title.setText("Java程序设计");
        author.setText("杨淑娟");
        year.setText("2019");
        price.setText("65.5");
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream("bookes.xml"),"utf-8");
        XMLWriter writer = new XMLWriter(w,prettyPrint);
        writer.write(document);
        writer.close();
        w.close();

    }
}
