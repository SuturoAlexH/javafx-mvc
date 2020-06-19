package com.javafxMvc.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * A property that hold a value that is evaluated and a visible property
 * for the error.
 *
 * @param <T> the type of the value that is evaluated
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
     * Resets the attributes to the initial state. This means the value is
     * null and visible is false.
     */
    public void reset(){
        value.set(null);
        isVisible.set(false);
    }
}
