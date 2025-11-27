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

    @FXML private MFXComboBox<Category> categoryComboBox;
    @FXML private MFXTextField amountTextField;
    @FXML private MFXTextField descriptionTextField;
    @FXML private MFXTextField idTextField;
    @FXML private MFXTextField dateTextField;
    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, Integer> idColumn;
    @FXML private TableColumn<Transaction, Category> categoryColumn;
    @FXML private TableColumn<Transaction, Float> amountColumn;
    @FXML private TableColumn<Transaction, String> descriptionColumn;
    @FXML private TableColumn<Transaction, String> dateColumn;
    @FXML private Label totalExpense;

    @FXML private void initialize() {
        loadComboBox();
        loadTable();
        setTotalExpense();
    }

    @SuppressWarnings("unused")
    @FXML private void addTransaction(ActionEvent actionEvent) {
        try {
            boolean transactionStatus = transactionHandler.addTransaction(categoryComboBox.getValue(), amountTextField.getText(), descriptionTextField.getText(), dateTextField.getText());
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
        categoryComboBox.getItems().removeAll(categoryComboBox.getItems());
        categoryComboBox.getItems().addAll(Category.values());
    }

    private void loadTable() {
        TableConfig tableConfig = new TableConfig();
        tableConfig.initialize(idColumn, categoryColumn, amountColumn, descriptionColumn, dateColumn);
        transactionTable.setItems(transactionHandler.initialize());
    }

    private void setTotalExpense() { totalExpense.setText(String.format("$%.2f", transactionHandler.getTotalExpense())); }

    private void clearFields() {
        amountTextField.clear();
        descriptionTextField.clear();
        idTextField.clear();
        categoryComboBox.clear();
        dateTextField.clear();
    }
}
