package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.MVCController;
import com.javafxMvc.model.MvcMap;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * This loader class instances the controllers.
 */
public class ControllerReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerReflectionLoader.class);

    /**
     * Instantiates the controllers and put it in the mvcMap.
     *
     * @param reflections the reflections to find the annotated classes
     * @param mvcMap a map tha contains classes as key and instances as values
     */
    public static void load(final Reflections reflections, final MvcMap mvcMap){
        Set<Class<?>> controllerClasses = reflections.getTypesAnnotatedWith(MVCController.class);

        controllerClasses.forEach(controllerClass -> {
            try {
                Constructor controllerConstructor = controllerClass.getConstructor();
                Object controller = controllerConstructor.newInstance();

                mvcMap.putController(controllerClass, controller);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}