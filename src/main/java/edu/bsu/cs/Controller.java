package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    private final Store store = new Store();

    @FXML
    private TextField expenseAmountField;

    @FXML
    private TextField descriptionField;

    @FXML
    private MFXButton expenseButton;

    @FXML
    private MFXButton incomeButton;

    @FXML
    private MFXButton removeButton;

    @FXML
    private MFXButton historyButton;

    @FXML
    public void addExpense() {
        try {
            float amount = Float.parseFloat(expenseAmountField.getText());
            String description = descriptionField.getText();
            store.addTransaction(amount, true, description);
            showAlert("Success", "Expense added: $" + amount + " - " + description);
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid amount! Please enter a valid number.");
        }
    }

    @FXML
    public void addIncome() {
        try {
            float amount = Float.parseFloat(expenseAmountField.getText());
            String description = descriptionField.getText();
            store.addTransaction(amount, false, description);
            showAlert("Success", "Income added: $" + amount + " - " + description);
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid amount! Please enter a valid number.");
        }
    }

    @FXML
    public void removeTransaction() {
        if (store.getAllTransactions().isEmpty()) {
            showAlert("Error", "No transactions to remove!");
        } else {
            Transaction last = store.getAllTransactions()
                    .get(store.getAllTransactions().size() - 1);
            store.removeTransaction(store.getAllTransactions().size() - 1);
            showAlert("Removed", "Removed last transaction: $" +
                    last.amount() + " - " + last.description());
        }
    }

    @FXML
    public void showTransactionHistory() {
        if (store.getAllTransactions().isEmpty()) {
            showAlert("Transaction History", "No transactions yet.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        float totalIncome = 0;
        float totalExpense = 0;

        for (int i = 0; i < store.getAllTransactions().size(); i++) {
            Transaction t = store.getTransaction(i);
            String type = t.type() ? "Expense" : "Income";
            sb.append(i + 1)
                    .append(". $")
                    .append(t.amount())
                    .append(" - ")
                    .append(t.description())
                    .append(" [")
                    .append(type)
                    .append("]\n");

            if (t.type()) totalExpense += t.amount();
            else totalIncome += t.amount();
        }

        sb.append("\nTotal Income: $").append(totalIncome)
                .append("\nTotal Expense: $").append(totalExpense)
                .append("\nBalance: $").append(totalIncome - totalExpense);

        showAlert("Transaction History", sb.toString());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        expenseAmountField.clear();
        descriptionField.clear();
    }
}
