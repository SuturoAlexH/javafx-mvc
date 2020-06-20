package com.javafxMvc.model;

import javafx.scene.Parent;

import java.util.*;

/**
 * The mvc map that holds the instances of the nodes, views, controllers and models.
 */
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

    /**
     * Returns all classes that are mapped to concrete instances.
     *
     * @return the list of classes
     */
    public List<Class> getMvcClasses(){
        Map<Class, Object> mvcMap = getMvcMap();
        return new ArrayList<>(mvcMap.keySet());
    }

    /**
     * Return the instance that belongs to this class.
     *
     * @param clazz the class
     * @return the instance
     */
    public Object getMvcObjectByClass(final Class<?> clazz){
        Map<Class, Object> mvcMap = getMvcMap();
        return mvcMap.get(clazz);
    }

    /**
     * The map of classes and instances.
     *
     * @return the map of classes that are mapped to instances
     */
    public Map<Class, Object> getMvcMap(){
        Map<Class, Object> mvcMap = new HashMap<>();

        mvcMap.putAll(models);
        mvcMap.putAll(controllers);
        mvcMap.putAll(views);

        return mvcMap;
    }
}