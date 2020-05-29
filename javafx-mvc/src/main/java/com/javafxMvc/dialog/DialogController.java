package com.javafxMvc.dialog;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class DialogController{

    private Stage stage;

    public DialogController(Parent dialog){
        super();

        initializeStage(dialog);
    }

    private void initializeStage(Parent dialog){
        Scene scene = new Scene(dialog);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);

        stage.setOnCloseRequest(e -> clear());
    }

    public void show(){
        Platform.runLater(() -> {
            stage.showAndWait();
        });
    }

    public void hide(){
       stage.hide();
       clear();
    }

    public abstract void clear();
}
