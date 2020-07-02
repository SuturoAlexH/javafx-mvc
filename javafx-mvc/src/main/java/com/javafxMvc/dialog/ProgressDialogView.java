package com.javafxMvc.dialog;

import javafx.concurrent.Task;
import javafx.stage.StageStyle;
import org.controlsfx.dialog.ProgressDialog;

/**
 * A dialog that displays the progress of a task.
 */
public class ProgressDialogView {

    /**
     * Shows the dialog and displays the current state of the task.
     *
     * @param task the task that should be mirrored
     */
    public void show(final String header, final Task<?> task) {
        ProgressDialog dialog = new ProgressDialog(task);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle(null);

        dialog.setHeaderText(header);

        new Thread(task).start();
        dialog.showAndWait();
    }
}