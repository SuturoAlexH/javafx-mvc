package com.javafxMvc.reflection.mvcMap;

public class NamedClass {
    private String name;

    private Class<?> clazz;

    public NamedClass(final String name, final Class<?> clazz){
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
