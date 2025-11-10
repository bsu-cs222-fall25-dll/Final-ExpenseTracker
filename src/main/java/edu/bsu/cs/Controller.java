package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class Controller {

    @FXML
    private ChoiceBox<String> transactionChoiceBox;
    @FXML
    private MFXButton expenseButton;
    @FXML
    private MFXButton incomeButton;
    @FXML
    private MFXButton removeButton;
    @FXML
    private MFXButton historyButton;

    private final Store store = new Store();
    private final Input input = new Input();
    private final Output output = new Output();

    @FXML
    public void initialize() {
        transactionChoiceBox.getItems().addAll(
                "Expense Menu",
                "Income Menu",
                "Remove Transaction",
                "Transaction History"
        );
        transactionChoiceBox.setValue("Expense Menu");
    }

    @FXML
    private void onChoiceSelected(ActionEvent event) {
        String selected = transactionChoiceBox.getValue();
        System.out.println("Selected: " + selected);

        switch (selected) {
            case "Expense Menu" -> openExpenseMenu();
            case "Income Menu" -> openIncomeMenu();
            case "Remove Transaction" -> removeTransaction();
            case "Transaction History" -> showTransactionHistory();
            default -> System.out.println("Unknown selection.");
        }
    }

    private void openExpenseMenu() {
        System.out.println("Opening Expense Menu...");
    }

    private void openIncomeMenu() {
        System.out.println("Opening Income Menu...");
    }

    private void removeTransaction() {
        System.out.println("Opening Remove Transaction Menu...");
    }

    private void showTransactionHistory() {
        System.out.println("Showing Transaction History...");
    }
}
