package com.javafxMvc.dialog;

import javafx.concurrent.Task;
import javafx.stage.StageStyle;
import org.controlsfx.dialog.ProgressDialog;

/**
 * A dialog that displays the progress of a task.
 */
public class ProgressDialogView {

    private String title;

    /**
     * Constructs a progress dialog and sets the title.
     *
     * @param title the title of the dialogs
     */
    public ProgressDialogView(final String title){
        this.title = title;
    }

    /**
     * Shows the dialog and displays the current state of the task.
     *
     * @param task the task that should be mirrored
     */
    public void show(final Task task) {
        ProgressDialog dialog = new ProgressDialog(task);

        dialog.setTitle(title);
        dialog.initStyle(StageStyle.UTILITY);

        new Thread(task).start();
        dialog.showAndWait();
    }
}