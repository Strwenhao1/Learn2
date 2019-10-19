package com.bjsxt.entity;

public class Entity {
    private String name;
    private String clazz;

    public Entity() {
        super();
    }

    public Entity(String name, String clazz) {
        super();
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
