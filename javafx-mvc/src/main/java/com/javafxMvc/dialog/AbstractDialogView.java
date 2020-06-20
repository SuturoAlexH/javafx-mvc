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

/**
 * The abstract base class for all dialogs. This means real dialogs with fxml file.
 */
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

    /**
     * Opens the dialog.
     */
    public void show(){
        Platform.runLater(() -> stage.showAndWait());
    }

    /**
     * Hides the dialog
     */
    public void hide(){
       stage.hide();
    }

    /**
     * Adds a listener to the cross button in the upper right corner.
     *
     * @param onClose
     */
    public void addCloseListener(Consumer<WindowEvent> onClose){
        stage.setOnCloseRequest(onClose::accept);
    }

    /**
     * Return the root pane
     *
     * @return the root pane
     */
    public Parent getRoot(){
        return rootPane;
    }
}
