package com.javafxMvc.l10n;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * This class is used for internationalisation.
 */
public class L10n {

    private final ResourceBundle resourceBundle;

    private static L10n instance;

    private L10n(final ResourceBundle resourceBundle){
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

    /**
     * Sets the resource bundle of the l10n.
     *
     * @param resourceBundle the resource bundle to specify the language
     */
    public static void load(final ResourceBundle resourceBundle){
        instance = new L10n(resourceBundle);
    }

    /**
     * Gets the instance of the l10n.
     *
     * @return the instance of the l10n
     */
    public static L10n getInstance(){
        return instance;
    }
}
