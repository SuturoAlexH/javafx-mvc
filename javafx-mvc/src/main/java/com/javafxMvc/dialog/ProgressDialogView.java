package com.javafxMvc.dialog;

import javafx.concurrent.Task;
import javafx.stage.StageStyle;
import org.controlsfx.dialog.ProgressDialog;

public class ProgressDialogView {

    private String title;

    public ProgressDialogView(final String title){
        this.title = title;
    }

    public void show(final Task task) {
        ProgressDialog dialog = new ProgressDialog(task);

        dialog.setTitle(title);
        dialog.initStyle(StageStyle.UTILITY);

        new Thread(task).start();
        dialog.showAndWait();
    }
}