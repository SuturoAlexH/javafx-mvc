package com.javafxMvc.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @param <T>
 */
public class ValidatableProperty<T> {
    SimpleObjectProperty<T> value = new SimpleObjectProperty<>();

    SimpleBooleanProperty isVisible = new SimpleBooleanProperty();

    public T getValue() {
        return value.get();
    }

    public SimpleObjectProperty<T> valueProperty() {
        return value;
    }

    public boolean isIsVisible() {
        return isVisible.get();
    }

    public SimpleBooleanProperty isVisibleProperty() {
        return isVisible;
    }

    /**
     *
     */
    public void reset(){
        value.set(null);
        isVisible.set(false);
    }
}
