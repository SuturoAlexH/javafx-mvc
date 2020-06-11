package com.javafxMvc.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class ValidatableProperty<T> {
    SimpleObjectProperty<T> value = new SimpleObjectProperty<>();

    SimpleBooleanProperty isVisible = new SimpleBooleanProperty();

    SimpleStringProperty error = new SimpleStringProperty();

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

    public String getError() {
        return error.get();
    }

    public SimpleStringProperty errorProperty() {
        return error;
    }

    public void reset(){
        value.set(null);
        isVisible.set(false);
        error.set("");
    }
}
