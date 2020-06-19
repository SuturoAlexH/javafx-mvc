package com.javafxMvc.reflection;

import com.javafxMvc.l10n.L10n;
import com.javafxMvc.annotations.InjectL10n;
import com.util.reflection.ReflectionIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * This loader class sets the L10n instance to all fields annotated with the InjectL10n annotation.
 */
public class L10nReflectionLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(L10nReflectionLoader.class);

    /**
     * Sets the L10n instance to all fields annotated with the InjectL10n annotation.
     *
     * @param mvcMap all classes mapped to the instance
     * @param resourceBundle the resource bundle to specify the language
     */
    public static void load(final Map<Class, Object> mvcMap, java.util.ResourceBundle resourceBundle){
        L10n l10n = new L10n(resourceBundle);

        ReflectionIterator.fields(mvcMap.keySet(), InjectL10n.class, (clazz, field) -> {
            try {
                field.setAccessible(true);
                field.set(mvcMap.get(clazz), l10n);
            } catch (IllegalAccessException e) {
                LOGGER.error(e.getMessage());
            }
        });
    }
}

