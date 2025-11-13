package edu.bsu.cs;

import javafx.scene.control.Alert;

public class ErrorDialog {

    Alert alert = new Alert(Alert.AlertType.ERROR);

    private void configure() {
        alert.setTitle("An error occurred");
        alert.setHeaderText(null);
    }

    public void showError(String message) {
        configure();
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showInvalidTypeError() {
        showError("""
                You entered an invalid type!
                The correct types are:
                 \
                - Type = Expense | Income
                 \
                - Amount = Float > 0
                 \
                - Description = String
                 - Transaction ID = Integer""");
    }

    public void showWriteFailedError() {
        showError("Failed to write to the CSV file. Does the file exist? Is the file structure correct?");
    }
}
