package com.javafxMvc.dialog;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractDialogView {

    @FXML
    private VBox rootPane;

    private Stage stage;

    @FXML
    public void initialize() {
        Scene scene = new Scene(rootPane);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
    }

    public void show(){
        Platform.runLater(() -> stage.showAndWait());
    }

    public void hide(){
       stage.hide();
    }

    public void addCloseListener(Consumer<WindowEvent> onClose){
        stage.setOnCloseRequest(onClose::accept);
    }

    public Parent getRoot(){
        return rootPane;
    }
}
