package com.javafxMvc.reflection;

import com.javafxMvc.l10n.L10n;
import com.javafxMvc.annotations.InjectL10n;
import com.util.reflection.ReflectionIterator;

import java.util.Map;

public class L10nReflectionLoader {

    public static void load(final Map<Class, Object> mvcMap, java.util.ResourceBundle resourceBundle){
        L10n l10n = new L10n(resourceBundle);

        ReflectionIterator.fields(mvcMap.keySet(), InjectL10n.class, (clazz, field) -> {
            try {
                field.setAccessible(true);
                field.set(mvcMap.get(clazz), l10n);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}

