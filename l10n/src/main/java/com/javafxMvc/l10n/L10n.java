package com.javafxMvc.l10n;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * This class is used for internationalisation.
 */
public class L10n {

    private final ResourceBundle resourceBundle;

    /**
     * Constructs a L10 from a resource bundle.
     *
     * @param resourceBundle the resource bundle to specify the language
     */
    public L10n(final ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    /**
     * Gets the value from the resource bundle by the given key.
     *
     * @param key the key
     * @return the value to the given key
     */
    public String get(final String key){
        return resourceBundle.getString(key);
    }

    /**
     * Gets the value from the resource bundle by the given key. And the
     * place holders are replaced with the provided arguments.
     *
     * @param key the key
     * @param arguments the place holder values
     * @return the value without place holders
     */
    public String get(final String key, final Object... arguments){
        return MessageFormat.format(resourceBundle.getString(key), arguments);
    }
}
