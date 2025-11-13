package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {

    private final TransactionHandler transactionHandler = new TransactionHandler();
    private final ErrorDialog errorDialog = new ErrorDialog();

    @FXML private MFXComboBox<String> typeComboBox;
    @FXML private MFXTextField amountTextField;
    @FXML private MFXTextField descriptionTextField;
    @FXML private MFXTextField idTextField;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, Integer> idColumn;
    @FXML private TableColumn<Transaction, String> typeColumn;
    @FXML private TableColumn<Transaction, Float> amountColumn;
    @FXML private TableColumn<Transaction, String> descriptionColumn;
    @FXML private Label totalExpense;

    @FXML private void initialize() {
        loadComboBox();
        loadTable();
        setTotalExpense();
    }

    @SuppressWarnings("unused")
    @FXML private void addTransaction(ActionEvent actionEvent) {
        try {
            boolean transactionStatus = transactionHandler.addTransaction(typeComboBox.getValue(), amountTextField.getText(), descriptionTextField.getText());
            if (!transactionStatus) errorDialog.showInvalidTypeError();
            else {
                setTotalExpense();
                clearFields();
            }
        } catch (IOException exception) { errorDialog.showWriteFailedError(); }
    }

    @SuppressWarnings("unused")
    @FXML private void removeTransaction(ActionEvent actionEvent) {
        try {
            boolean transactionStatus = transactionHandler.removeTransaction(idTextField.getText());
            if (!transactionStatus) errorDialog.showInvalidTypeError();
            else {
                setTotalExpense();
                clearFields();
            }
        } catch (IOException exception) { errorDialog.showWriteFailedError(); }
    }

    private void loadComboBox() {
        typeComboBox.getItems().removeAll(typeComboBox.getItems());
        typeComboBox.getItems().addAll("Expense", "Income");
    }

    private void loadTable() {
        TableConfig table = new TableConfig();
        table.configureTable(idColumn, typeColumn, amountColumn, descriptionColumn);
        transactionTable.setItems(transactionHandler.initialize());
    }

    private void setTotalExpense() { totalExpense.setText(String.format("$%.2f", transactionHandler.getTotalExpense())); }

    private void clearFields() {
        amountTextField.clear();
        descriptionTextField.clear();
        idTextField.clear();
        typeComboBox.clear();
    }
}
