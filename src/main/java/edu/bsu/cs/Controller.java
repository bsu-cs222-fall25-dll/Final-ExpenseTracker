package edu.bsu.cs;

import io.github.palexdev.materialfx.controls.*;
import io.github.palexdev.mfxcore.controls.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Controller {

    private final ErrorDialog errorDialog = new ErrorDialog();
    private final ObservableList<Transaction> transactionList = FXCollections.observableArrayList();
    private final TransactionHandler transactionHandler = new TransactionHandler(transactionList);

    @FXML private MFXComboBox<Category> categoryComboBox;
    @FXML private MFXTextField amountTextField;
    @FXML private MFXTextField descriptionTextField;
    @FXML private MFXDatePicker dateField;
    @FXML private MFXButton deleteButton;
    @FXML private MFXTableView<Transaction> transactionTable;
    @FXML private Label totalExpense;

    @FXML private void initialize() {
        loadComboBox();
        loadTable();
        setTotalExpense();
    }

    @SuppressWarnings("unused")
    @FXML private void addTransaction(ActionEvent actionEvent) {
        try {
            boolean transactionStatus = transactionHandler.addTransaction(categoryComboBox.getValue(), amountTextField.getText(), descriptionTextField.getText(), dateField.getValue());
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
            Transaction selectedTransaction = transactionTable.getSelectionModel().getSelectedValue();
            if (selectedTransaction != null) {
                ObservableList<Transaction> tableItems = transactionTable.getItems();
                int selectedItemIndex = tableItems.indexOf(selectedTransaction);
                transactionHandler.removeTransaction(selectedItemIndex);
                setTotalExpense();
            }
        } catch (IOException exception) { errorDialog.showWriteFailedError(); }
    }

    @SuppressWarnings("unused")
    @FXML public void openChartDialog(ActionEvent actionEvent) {
        ChartDialog chartDialog = new ChartDialog();
        chartDialog.showChart(transactionList);
    }

    private void loadComboBox() {
        categoryComboBox.getItems().removeAll(categoryComboBox.getItems());
        categoryComboBox.getItems().addAll(Category.values());
    }

    private void loadTable() {
        transactionTable.setItems(transactionHandler.initialize());
        TableConfig tableConfig = new TableConfig(transactionTable, transactionList);
        tableConfig.initialize(deleteButton);
    }

    private void setTotalExpense() { totalExpense.setText(String.format("$%.2f", transactionHandler.getTotalExpense())); }

    private void clearFields() {
        amountTextField.clear();
        descriptionTextField.clear();
        categoryComboBox.clear();
        dateField.clear();
    }
}
