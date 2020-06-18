package com.javafxMvc.reflection.mvc;

import com.javafxMvc.annotations.MVCView;
import com.javafxMvc.model.MvcMap;
import javafx.fxml.FXMLLoader;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Set;

public class ViewReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewReflectionLoader.class);

    public static void load(final Reflections reflections, final MvcMap mvcMap, final ResourceBundle resourceBundle){
        Set<Class<?>> viewClasses = reflections.getTypesAnnotatedWith(MVCView.class);

        viewClasses.forEach(viewClass -> {
            try {
                String fxmlFileName = viewClass.getAnnotation(MVCView.class).value();
                FXMLLoader fxmlLoader = new FXMLLoader(ViewReflectionLoader.class.getResource(fxmlFileName), resourceBundle);

                mvcMap.putNode(viewClass, fxmlLoader.load());
                mvcMap.putView(viewClass, fxmlLoader.getController());
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}
