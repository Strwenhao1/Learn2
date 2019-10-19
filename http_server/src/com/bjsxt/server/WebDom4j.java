package com.bjsxt.server;

import com.bjsxt.entity.Entity;
import com.bjsxt.mapping.Mapping;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebDom4j {
    private List<Entity> entityList;
    private List<Mapping> mappingList;

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    public void setMappingList(List<Mapping> mappingList) {
        this.mappingList = mappingList;
    }

    public WebDom4j() {
        entityList = new ArrayList<Entity>();
        mappingList = new ArrayList<Mapping>();
    }

    public Document getDocument() {
        SAXReader reader = new SAXReader();
        try {
            return reader.read(new File("D:\\javaLearn\\listAndset\\http_server\\src\\WEB_INFO/web.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void parse(Document doc) {
        Element root = doc.getRootElement();
        for (Iterator<Element> ite = root.elementIterator("servlet"); ite.hasNext(); ) {
            Element subElement = ite.next();
            Entity ent = new Entity();
            subElement.elementIterator();
            for (Iterator<Element> subIte = subElement.elementIterator(); subIte.hasNext(); ) {
                Element ele = subIte.next();
                if ("servlet-name".equals(ele.getName())){
                    ent.setName(ele.getText());

                }else if("servlet-class".equals(ele.getName())){
                    ent.setClazz(ele.getText());
                }
            }
        entityList.add(ent);
        }
//        for (Entity entity:entityList){
//            System.out.println(entity.getName()+"\t"+entity.getClazz());
//        }
        for (Iterator<Element> ite = root.elementIterator("servlet-mapping");ite.hasNext();){
            Element subEle = ite.next();
            Mapping map = new Mapping();
            for (Iterator<Element> subIte = subEle.elementIterator();subIte.hasNext();){
                Element ele = subIte.next();
                if ("servlet-name".equals(ele.getName())){
                    map.setName(ele.getText());
                }else if("url-pattern".equals(ele.getName())){
                    map.getUrlPattern().add(ele.getText());
                }
            }
            mappingList.add(map);
        }
//        for (Mapping map:mappingList){
//            System.out.println(map.getName());
//            for (String s:map.getUrlPattern()){
//                System.out.println(s);
//            }
//        }
    }

    public static void main(String[] args) {
        WebDom4j web = new WebDom4j();
        web.parse(web.getDocument());
    }
}
