package com.javafxMvc.reflection;

import com.javafxMvc.annotations.MVCView;
import com.javafxMvc.reflection.mvcMap.MvcMap;
import com.javafxMvc.reflection.mvcMap.NamedClass;
import javafx.fxml.FXMLLoader;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.Set;

public class ViewReflectionLoader {

    public static void load(final String packagePath, final MvcMap mvcMap){
        Reflections reflections = new Reflections(packagePath);
        Set<Class<?>> viewClasses = reflections.getTypesAnnotatedWith(MVCView.class);

        viewClasses.forEach(viewClass -> {
            String fxmlFileName = viewClass.getAnnotation(MVCView.class).value();
            try {
                String name = StringUtils.substringBefore(viewClass.getSimpleName(), "View");
                NamedClass namedClass = new NamedClass(name, viewClass);

                FXMLLoader fxmlLoader = new FXMLLoader(ViewReflectionLoader.class.getResource(fxmlFileName));

                mvcMap.putNode(namedClass, fxmlLoader.load());
                mvcMap.putView(namedClass, fxmlLoader.getController());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
