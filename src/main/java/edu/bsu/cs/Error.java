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
}
