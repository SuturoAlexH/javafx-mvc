package com.javafxMvc.dialog;

import javafx.concurrent.Task;
import javafx.stage.StageStyle;
import org.controlsfx.dialog.ProgressDialog;

public class ProgressDialogUtil {

    public static void show(final Task task){
        ProgressDialog dialog = new ProgressDialog(task);

        dialog.setContentText("Files are Uploading");
        dialog.setTitle("Files Uploading");
        dialog.setHeaderText("This is demo");
        dialog.initStyle(StageStyle.UTILITY);

        new Thread(task).start();
        dialog.showAndWait();
    }
}