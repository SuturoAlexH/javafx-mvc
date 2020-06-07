package com.javafxMvc.model;

import javafx.scene.Parent;

import java.util.*;

public class MvcMap {

    private Map<Class, Parent> nodes = new HashMap<>();

    private Map<Class, Object> models = new HashMap<>();

    private Map<Class, Object> controllers = new HashMap<>();

    private Map<Class, Object> views = new HashMap<>();

    public void putNode(final Class viewClass, final Parent node){
        nodes.put(viewClass, node);
    }

    public Parent getNodeByClass(final Class clazz){
        return nodes.get(clazz);
    }

    public void putModel(final Class clazz, final Object model){
        models.put(clazz, model);
    }

    public List<Class> getModelClasses(){
        return new ArrayList<>(models.keySet());
    }

    public void putController(final Class clazz, final Object controller){
        controllers.put(clazz, controller);
    }

    public List<Class> getControllerClasses(){
        return new ArrayList<>(controllers.keySet());
    }

    public void putView(final Class clazz, final Object view){
        views.put(clazz, view);
    }

    public List<Class> getMvcClasses(){
        List<Class> mvcClasses = new ArrayList<>();

        mvcClasses.addAll(models.keySet());
        mvcClasses.addAll(controllers.keySet());
        mvcClasses.addAll(views.keySet());

        return mvcClasses;
    }

    public Object getMvcObjectByClass(final Class<?> clazz){
        Map<Class, Object> mvcMap = new HashMap<>();

        mvcMap.putAll(models);
        mvcMap.putAll(controllers);
        mvcMap.putAll(views);

        return mvcMap.get(clazz);
    }

    public Map<Class, Object> getMvcMap(){
        Map<Class, Object> mvcMap = new HashMap<>();

        mvcMap.putAll(models);
        mvcMap.putAll(controllers);
        mvcMap.putAll(views);

        return mvcMap;
    }
}