package edu.bsu.cs;

import javafx.scene.control.Alert;

public class Error {

    Alert alert = new Alert(Alert.AlertType.ERROR);

    private void configureDialog() {
        alert.setTitle("An error occurred");
        alert.setHeaderText(null);
    }

    public void showError(String message) {
        configureDialog();
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
                - Amount = Float
                 \
                - Description = String
                 - Transaction ID = Integer""");
    }
}
