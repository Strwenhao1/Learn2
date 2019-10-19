package com.bjsxt.server;

import com.bjsxt.entity.Entity;
import com.bjsxt.mapping.Mapping;
import com.bjsxt.servlet.Servlet;

import java.util.List;
import java.util.Map;

public class WebApp {
    private static ServletContext context;

    static {
        context = new ServletContext();
        Map<String, String> servlet = context.getServlet();
        Map<String, String> mapping = context.getMapping();
        WebDom4j web = new WebDom4j();
        web.parse(web.getDocument());
        List<Entity> entityList = web.getEntityList();
        List<Mapping> mappingList = web.getMappingList();
        for (Entity entity : entityList) {
//            System.out.println(entity);
            servlet.put(entity.getName(), entity.getClazz());
        }
        for (Mapping map : mappingList) {
            List<String> urlPattern = map.getUrlPattern();
            for (String s : urlPattern) {
                mapping.put(s, map.getName());
            }
        }
//        System.out.println(mapping);
    }

    /***
     * 根据url创建不同的Servlet对象
     * @param url
     * @return
     */
    public static Servlet getServlet(String url) {
        if (url == null || url.trim().equals("")) {
            return null;
        }
        String servletName = context.getMapping().get(url);
        String servletClass = context.getServlet().get(servletName);
        Class<?> clazz = null;
        Servlet servlet = null;
        try {
//            System.out.println(servletClass);
            clazz = Class.forName(servletClass);
            servlet = (Servlet) clazz.newInstance();
            return servlet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(getServlet("/log"));

    }
}
