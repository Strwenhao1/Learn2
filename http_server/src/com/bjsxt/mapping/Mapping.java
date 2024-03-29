package com.bjsxt.mapping;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
    private String name;
    private List<String> urlPattern;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrlPattern() {
        return urlPattern;
    }

    public void setUrlPattern(List<String> urlPattern) {
        this.urlPattern = urlPattern;
    }

    public Mapping() {
        urlPattern = new ArrayList<String>();
    }

    public Mapping(String name, List<String> urlPattern) {
        super();
        this.name = name;
        this.urlPattern = urlPattern;
    }
}
