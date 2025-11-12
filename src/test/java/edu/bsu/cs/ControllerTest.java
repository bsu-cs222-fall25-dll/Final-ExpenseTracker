package edu.bsu.cs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ControllerTest {

    @FXML
    private ChoiceBox<String> transactionChoiceBox;

    private final Store store = new Store("./testStore.csv");
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
    private void addIncome(ActionEvent event) {
        store.addTransaction(100.0f, false, "Paycheck");
        System.out.println("Income added!");
    }

    @FXML
    private void addExpense(ActionEvent event) {
        store.addTransaction(25.0f, true, "Lunch");
        System.out.println("Expense added!");
    }

    @FXML
    private void removeTransaction(ActionEvent event) {
        if (!store.getAllTransactions().isEmpty()) {
            store.removeTransaction(store.getAllTransactions().size() - 1);
            System.out.println("Removed last transaction");
        } else {
            System.out.println("No transactions to remove!");
        }
    }

    @FXML
    private void showTransactionHistory(ActionEvent event) {
        output.showTransactions(store.getAllTransactions());
    }

    @FXML
    private void onChoiceSelected(ActionEvent event) {
        System.out.println("ChoiceBox selected: " + transactionChoiceBox.getValue());
    }
}
