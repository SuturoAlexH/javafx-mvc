package com.javafxMvc.l10n;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class L10n {

    private final ResourceBundle resourceBundle;

    public L10n(final ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }

    public String get(final String key){
        return resourceBundle.getString(key);
    }

    public String get(final String key, final Object... arguments){
        return MessageFormat.format(resourceBundle.getString(key), arguments);
    }
}
