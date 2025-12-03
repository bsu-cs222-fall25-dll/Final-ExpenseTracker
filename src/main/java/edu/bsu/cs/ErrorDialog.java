package edu.bsu.cs;

import javafx.scene.control.Alert;

public class ErrorDialog {

    Alert alert = new Alert(Alert.AlertType.ERROR);

    private void configure() {
        alert.setTitle("An error occurred");
        alert.setHeaderText(null);
        alert.setWidth(580);
        alert.setHeight(180);
    }

    public void showError(String message) {
        configure();
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showInvalidTypeError() {
        showError("""
                You entered an invalid type!
                The correct types are (These types are required):
                 \
                - Category = GAS, INCOME, GROCERY, UTILITY, ENTERTAINMENT, FOOD, HEALTH, SHOPPING
                 \
                - Amount = Float > 0
                 - Date = Date""");
    }

    public void showWriteFailedError() {
        showError("Failed to write to the CSV file. Does the file exist? Is the file structure correct?");
    }
}
