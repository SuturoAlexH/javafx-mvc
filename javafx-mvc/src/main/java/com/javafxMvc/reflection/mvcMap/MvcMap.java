package com.javafxMvc.reflection.mvcMap;

import com.javafxMvc.validator.CombinedValidator;
import javafx.scene.Parent;

import java.util.*;
import java.util.stream.Collectors;

public class MvcMap {

    private Map<NamedClass, Parent> nodes = new HashMap<>();

    private Map<NamedClass, Object> models = new HashMap<>();

    private Map<NamedClass, Object> controllers = new HashMap<>();

    private Map<NamedClass, Object> views = new HashMap<>();

    private Map<Class, CombinedValidator> combinedValidators = new HashMap<>();

    public void putNode(NamedClass namedClass, final Parent node){
        nodes.put(namedClass, node);
    }

    public Parent getNodeByName(final String name){
        Optional<NamedClass> namedClassOptional = nodes.keySet().stream().filter(namedClass -> namedClass.getName().equals(name)).findFirst();
        return namedClassOptional.map(namedClass -> nodes.get(namedClass)).orElse(null);
    }

    public void putModel(NamedClass namedClass, final Object model){
        models.put(namedClass, model);
    }

    public List<Class<?>> getModelClasses(){
        return models.keySet().stream().map(NamedClass::getClazz).collect(Collectors.toList());
    }

    public void putController(NamedClass namedClass, final Object controller){
        controllers.put(namedClass, controller);
    }

    public List<Class<?>> getControllerClasses(){
        return controllers.keySet().stream().map(NamedClass::getClazz).collect(Collectors.toList());
    }

    public Object getControllerByName(final String name){
        Optional<NamedClass> namedClassOptional = controllers.keySet().stream().filter(namedClass -> namedClass.getName().equals(name)).findFirst();
        return namedClassOptional.map(controllers::get).orElse(null);
    }

    public void putView(NamedClass namedClass, final Object view){
        views.put(namedClass, view);
    }

    public void putCombinedValidator(final Class clazz, final CombinedValidator combinedValidator){
        combinedValidators.put(clazz, combinedValidator);
    }

    public CombinedValidator getCombinedValidator(final Class clazz){
       return combinedValidators.get(clazz);
    }

    public List<Class<?>> getMvcClasses(){
        List<NamedClass> mvcNamedClasses = new ArrayList<>();

        mvcNamedClasses.addAll(models.keySet());
        mvcNamedClasses.addAll(controllers.keySet());
        mvcNamedClasses.addAll(views.keySet());

        return mvcNamedClasses.stream().map(NamedClass::getClazz).collect(Collectors.toList());
    }

    public Object getMvcObjectByClass(final Class<?> clazz){
        Map<NamedClass, Object> mvcMap = new HashMap<>();

        mvcMap.putAll(models);
        mvcMap.putAll(controllers);
        mvcMap.putAll(views);

        Optional<NamedClass> namedClassOptional = mvcMap.keySet().stream().filter(namedClass -> namedClass.getClazz().getSimpleName().equals(clazz.getSimpleName())).findFirst();
        return namedClassOptional.map(mvcMap::get).orElse(null);
    }
}