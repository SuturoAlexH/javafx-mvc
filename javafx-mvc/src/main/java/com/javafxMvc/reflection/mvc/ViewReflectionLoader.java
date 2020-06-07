package com.javafxMvc.reflection;

import com.javafxMvc.annotations.MVCView;
import com.javafxMvc.model.MvcMap;
import javafx.fxml.FXMLLoader;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.Set;

public class ViewReflectionLoader {

    public static void load(final Reflections reflections, final MvcMap mvcMap){
        Set<Class<?>> viewClasses = reflections.getTypesAnnotatedWith(MVCView.class);

        viewClasses.forEach(viewClass -> {
            try {
                String fxmlFileName = viewClass.getAnnotation(MVCView.class).value();
                FXMLLoader fxmlLoader = new FXMLLoader(ViewReflectionLoader.class.getResource(fxmlFileName));

                mvcMap.putNode(viewClass, fxmlLoader.load());
                mvcMap.putView(viewClass, fxmlLoader.getController());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
